package org.codeandmagic.affected.svn.api;

import org.codeandmagic.affected.user.User;

import java.util.Set;

// @affects: SvnProjectProcessor

/**
 * Gets all the paths that have been modified on svn, between the project's local revision and the
 * target revision.
 */
public interface SvnPathChangeChecker {
    /**
     * @param project        the given {@link SvnProject}
     * @param user           the user whose credentials are used to connect to the svn
     * @param targetRevision the upper-limit revision for which we want the changes
     *
     * @return all the paths that were changed in the project, between project's local version and
     *         target revision
     *
     * @throws SvnException if an exception occurred while getting the changed paths
     */
    Set<String> getChangedPaths(SvnProject project, User user, long targetRevision) throws SvnException;
}
