package org.codeandmagic.affected.svn.impl.svnkit;

import org.codeandmagic.affected.scanner.api.TagScanner;
import org.codeandmagic.affected.service.api.SvnProjectService;
import org.codeandmagic.affected.svn.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class SvnKitProjectProcessor implements SvnProjectProcessor {
    private SvnVersionChecker versionChecker;
    private SvnPathChangeChecker changeChecker;
    private SvnFileTypeChecker fileTypeChecker;
    private SvnFileContentRetriever fileContentRetriever;
    private TagScanner tagScanner;
    private SvnProjectService service;

    @Required
    public void setVersionChecker(SvnVersionChecker versionChecker) {
        this.versionChecker = versionChecker;
    }

    @Required
    public void setChangeChecker(SvnPathChangeChecker changeChecker) {
        this.changeChecker = changeChecker;
    }

    @Required
    public void setFileTypeChecker(SvnFileTypeChecker fileTypeChecker) {
        this.fileTypeChecker = fileTypeChecker;
    }

    @Required
    public void setFileContentRetriever(SvnFileContentRetriever fileContentRetriever) {
        this.fileContentRetriever = fileContentRetriever;
    }

    @Required
    public void setTagScanner(TagScanner tagScanner) {
        this.tagScanner = tagScanner;
    }

    @Required
    @Autowired
    public void setService(SvnProjectService service) {
        this.service = service;
    }

    public Map<String, List<String>> process(SvnProject project) throws SvnException {
        // 1# get the target revision from the svn
        long targetVersion = versionChecker.getRemoteVersion(project);

        // 2# get the modified file paths from the svn
        Set<String> changedPaths = changeChecker.getChangedPaths(project, targetVersion);

        // 3# for each modified file, retrieve the content from the svn
        Map<String, String> fileContents = new HashMap<String, String>();
        for (String filePath : changedPaths) {
            if (filePath != null && !filePath.isEmpty()
                    && fileTypeChecker.getFileType(project, filePath, targetVersion) == SvnFileType.FILE) {
                fileContents.put(filePath, fileContentRetriever.getFileContent(project, filePath, targetVersion));
            }
        }

        // 4# parse the content of each file in order to retrieve the tags
        Map<String, List<String>> tags = new HashMap<String, List<String>>();
        for (Map.Entry<String, String> entry : fileContents.entrySet()) {
            tags.put(entry.getKey(), tagScanner.scan(entry.getValue()));
        }

        return tags;
    }

}
