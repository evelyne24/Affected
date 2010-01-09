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

/**
 * This processor will receive information about a working copy of a svn project and perform the
 * following actions upon it:
 * <ul>
 * <li> gather the modified files list</li>
 * <li> for each modified file, retrieve its content from the svn</li>
 * <li> parse the content of the modified file in order to retrieve the '@affects'' tags</li>
 * <li> modify the local version of the project in the database,
 * to mark the fact that this version was processed</li>
 * </ul>
 */
public interface SvnProjectProcessor {
    /**
     * For the given project, perform the operations described above
     *
     * @param project the {@link org.codeandmagic.affected.svn.api.SvnProject} to be scanned for tags
     *
     * @return a set of parsed '@affects' tags found in that file
     */
    Set<String> process(SvnProject project) throws SvnException;
}
