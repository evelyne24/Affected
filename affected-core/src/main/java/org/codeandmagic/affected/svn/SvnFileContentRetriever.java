package org.codeandmagic.affected.svn;


// @affects: SvnProjectProcessor

/** Retrieves the content of a file from the svn. */
public interface SvnFileContentRetriever {
	/**
	 * @param project
	 *            the svn project object
	 * @param filePath
	 *            the path to the file whose content we want
	 * @param targetRevision
	 *            the revision of the file
	 * 
	 * @return a string representing the entire content of the file
	 * 
	 * @throws SvnException
	 *             if an exception occurred while checking out or reading the
	 *             content of the file
	 */
	String getFileContent(SvnProject project, String filePath,
			long targetRevision) throws SvnException;
}
