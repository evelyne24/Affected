/*******************************************************************************
 * Copyright© 2010 Cristian Vrabie, Evelina Petronela Vrabie
 *
 * This file is part of Affected.
 *
 * Affected is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Affected is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Affected.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

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
