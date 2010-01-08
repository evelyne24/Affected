package org.codeandmagic.affected.test;

import org.codeandmagic.affected.scanner.impl.SimpleTagScanner;
import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;
import org.codeandmagic.affected.svn.impl.svnkit.*;
import org.tmatesoft.svn.core.SVNException;

public class Main {

    public static void main(String[] args) throws SvnException, SVNException {
        SvnProject proj = new SvnProject();
        proj.setLocalVersion(2041);
        proj.setPassword("Uy7zUBzM");
        proj.setUrl("https://dev.ddnet.ro/svn/core/gamecore/trunk/affected/");
        proj.setUsername("evelina.vrabie");

        int targetRev = 2040;


        SvnKitManagerPool pool = new SvnKitManagerPool();
        pool.init();

        SvnKitVersionChecker versionChecker = new SvnKitVersionChecker();
        versionChecker.setManagerPool(pool);
        //System.out.println("LATEST REV=" + versionChecker.getRemoteVersion(proj));

        SvnKitPathChangeChecker changeChecker = new SvnKitPathChangeChecker();
        changeChecker.setManagerPool(pool);
        //Set<String> results = changeChecker.getChangedPaths(proj, targetRev);
        //System.out.println("RESULTS=" + results + "\n");

        SvnKitFileContentRetriever fileRetriever = new SvnKitFileContentRetriever();
        fileRetriever.setManagerPool(pool);
        /*for(String path : results) {
            if(path != null && !path.isEmpty())
                System.out.println("FILE PATH =" + path);
                System.out.println(fileRetriever.getFileContent(proj, path, targetRev));
        }*/
        //String filePath = "/trunk/affected/affected-core/src/main/java/org/codeandmagic/affected/svn/api/SvnProjectProcessor.java";
        //System.out.println(fileRetriever.getFileContent(proj, filePath, targetRev));

        SvnKitFileTypeChecker typeChecker = new SvnKitFileTypeChecker();
        typeChecker.setManagerPool(pool);
        //String dirPath = "src/main/java/org/codeandmagic/affected/svn/api";
        //System.out.println("FILE TYPE = " + typeChecker.getFileType(proj, dirPath, targetRev));

        SvnKitProjectProcessor processor = new SvnKitProjectProcessor();
        processor.setChangeChecker(changeChecker);
        processor.setVersionChecker(versionChecker);
        processor.setFileContentRetriever(fileRetriever);
        processor.setFileTypeChecker(typeChecker);
        processor.setTagScanner(new SimpleTagScanner());

        System.out.println(processor.process(proj));

    }
}