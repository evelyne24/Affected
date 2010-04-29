package org.codeandmagic.affected.svn.svnkit;

import org.codeandmagic.affected.svn.SvnException;
import org.codeandmagic.affected.svn.SvnFileType;
import org.codeandmagic.affected.svn.SvnFileTypeChecker;
import org.codeandmagic.affected.svn.SvnProject;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;

public class SvnKitFileTypeChecker extends SvnKitAbstractRepository implements
		SvnFileTypeChecker {

	public SvnFileType getFileType(SvnProject project, String path,
			long targetRevision) throws SvnException {
		try {
			SVNNodeKind type = managerPool.getSvnRepository(project).checkPath(
					path, targetRevision);
			if (type.equals(SVNNodeKind.FILE)) {
				return SvnFileType.FILE;
			}
			if (type.equals(SVNNodeKind.DIR)) {
				return SvnFileType.DIR;
			}
			if (type.equals(SVNNodeKind.NONE)) {
				return SvnFileType.NONE;
			}
			if (type.equals(SVNNodeKind.UNKNOWN)) {
				return SvnFileType.UNKNOWN;
			}
			throw new SvnException("Could not verify the type for path " + path);
		} catch (SVNException e) {
			throw new SvnException("Exception while getting the type of path "
					+ path, e);
		}
	}

}
