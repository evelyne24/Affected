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

import java.util.Set;

// @affects: SvnProjectProcessor

/**
 * Gets all the paths that have been modified on svn, between the project's local revision and the
 * target revision.
 */
public interface SvnPathChangeChecker {
    /**
     * @param project        the given {@link SvnProject}
     * @param targetRevision the upper-limit revision for which we want the changes
     *
     * @return all the paths that were changed in the project, between project's local version and
     *         target revision
     *
     * @throws SvnException if an exception occurred while getting the changed paths
     */
    Set<String> getChangedPaths(SvnProject project, long targetRevision) throws SvnException;
}
