package org.codeandmagic.affected.svn;


// @affects: SvnProjectProcessor

/** Checks to see if a given path represents a file or a directory. */
public interface SvnFileTypeChecker {
	/**
	 * @param project
	 *            the svn project
	 * @param path
	 *            the path to be checked
	 * @param targetRevision
	 *            the revision for which we want to check
	 * 
	 * @return an {@link SvnFileType} representing the type of the file
	 * 
	 * @throws SvnException
	 *             if an exception occurred while performing the check
	 */
	public SvnFileType getFileType(SvnProject project, String path,
			long targetRevision) throws SvnException;
}
