package org.codeandmagic.affected.svn.impl.svnkit;

import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;
import org.codeandmagic.affected.svn.api.SvnVersionChecker;
import org.codeandmagic.affected.user.User;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.wc.SVNInfo;
import org.tmatesoft.svn.core.wc.SVNRevision;

public class SvnKitVersionChecker extends SvnKitAbstractClientManager implements SvnVersionChecker {

    public long getRemoteVersion(SvnProject project, User user) throws SvnException {
        try {
            SVNInfo svnInfo = managerPool.getSvnManager(project, user).getWCClient().doInfo(
                    SVNURL.parseURIEncoded(project.getUrl()), SVNRevision.HEAD, SVNRevision.HEAD);
            return svnInfo.getCommittedRevision().getNumber();

        } catch (SVNException e) {
            throw new SvnException(
                    "Exception while trying to get the remote svn version for project " + project,
                    e);
        }
    }

}
