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
