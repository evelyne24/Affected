package org.codeandmagic.affected.svn.impl.svnkit;

import org.codeandmagic.affected.scanner.api.TagScanner;
import org.codeandmagic.affected.service.api.SvnProjectService;
import org.codeandmagic.affected.svn.api.*;
import org.codeandmagic.affected.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import java.util.*;

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

    public Set<String> process(SvnProject project, User user) throws SvnException {
        // 1# get the target revision from the svn
        long targetVersion = versionChecker.getRemoteVersion(project, user);

        // 2# get the modified file paths from the svn
        Set<String> changedPaths = changeChecker.getChangedPaths(project, user, targetVersion);

        // 3# for each modified file, retrieve the content from the svn
        Map<String, String> fileContents = new HashMap<String, String>();
        for (String filePath : changedPaths) {
            if (filePath != null && !filePath.isEmpty()
                    && fileTypeChecker.getFileType(project, user, filePath, targetVersion) == SvnFileType.FILE) {
                fileContents.put(filePath, fileContentRetriever.getFileContent(project, user, filePath, targetVersion));
            }
        }

        // 4# parse the content of each file in order to retrieve the tags
        Set<String> tags = new HashSet<String>();
        for (Map.Entry<String, String> entry : fileContents.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().isEmpty()) {
                List<String> tagList = tagScanner.scan(entry.getValue());
                if (tagList != null) {
                    tags.addAll(tagList);
                }
            }
        }

        // 5# save the tags in the database

        // 6# change the last checked version to targetVersion
        //project.setLastCheckedVersion(targetVersion);

        // 7# save the project
        //service.save(project);

        return tags;
    }

}