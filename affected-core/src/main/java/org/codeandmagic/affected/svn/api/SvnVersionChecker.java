package org.codeandmagic.affected.svn.api;

import org.codeandmagic.affected.user.User;

// @affects: SvnProjectProcessor

/** Gets the version of the project on svn. */
public interface SvnVersionChecker {
    /**
     * @param project the given {@link SvnProject}
     * @param user    the user whose credentials are used to connect to the svn
     *
     * @return the version of the project
     *
     * @throws SvnException if an exception occurred while getting the version
     */
    long getRemoteVersion(SvnProject project, User user) throws SvnException;
}
