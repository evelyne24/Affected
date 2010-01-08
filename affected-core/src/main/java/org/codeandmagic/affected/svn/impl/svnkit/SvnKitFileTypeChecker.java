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
import org.codeandmagic.affected.svn.api.SvnFileType;
import org.codeandmagic.affected.svn.api.SvnFileTypeChecker;
import org.codeandmagic.affected.svn.api.SvnProject;
import org.codeandmagic.affected.user.User;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;

public class SvnKitFileTypeChecker extends SvnKitAbstractRepository implements SvnFileTypeChecker {

    public SvnFileType getFileType(SvnProject project, User user, String path, long targetRevision) throws SvnException {
        try {
            SVNNodeKind type = managerPool.getSvnRepository(project, user).checkPath(path, targetRevision);
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
            throw new SvnException("Exception while getting the type of path " + path, e);
        }
    }

}
