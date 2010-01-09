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

// @affects: SvnProjectProcessor

/** Checks to see if a given path represents a file or a directory. */
public interface SvnFileTypeChecker {
    /**
     * @param project        the svn project
     * @param path           the path to be checked
     * @param targetRevision the revision for which we want to check
     *
     * @return an {@link SvnFileType} representing the type of the file
     *
     * @throws SvnException if an exception occurred while performing the check
     */
    public SvnFileType getFileType(SvnProject project, String path, long targetRevision) throws SvnException;
}
