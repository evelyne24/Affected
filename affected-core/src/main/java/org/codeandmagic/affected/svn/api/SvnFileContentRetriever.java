package org.codeandmagic.affected.svn.api;

import org.codeandmagic.affected.user.User;

// @affects: SvnProjectProcessor

/** Retrieves the content of a file from the svn. */
public interface SvnFileContentRetriever {
    /**
     * @param project        the svn project object
     * @param user           the user whose credentials are used to connect to the svn
     * @param filePath       the path to the file whose content we want
     * @param targetRevision the revision of the file
     *
     * @return a string representing the entire content of the file
     *
     * @throws SvnException if an exception occurred while checking out or reading the content of
     *                      the file
     */
    String getFileContent(SvnProject project, User user,
                          String filePath, long targetRevision) throws SvnException;
}
