package org.codeandmagic.affected.svn;


// @affects: SvnProjectProcessor

/** Gets the version of the project on svn. */
public interface SvnVersionChecker {
	/**
	 * @param project
	 *            the given {@link SvnProject}
	 * 
	 * @return the version of the project
	 * 
	 * @throws SvnException
	 *             if an exception occurred while getting the version
	 */
	long getRemoteVersion(SvnProject project) throws SvnException;
}
