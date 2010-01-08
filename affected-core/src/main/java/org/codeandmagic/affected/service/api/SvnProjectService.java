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

package org.codeandmagic.affected.service.api;

import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;

import java.util.List;

public interface SvnProjectService {
    SvnProject get(String name) throws SvnException;

    List<SvnProject> getAll();

    SvnProject create(String name, String url, long lastCheckedVersion) throws SvnException;

    void save(SvnProject project);

    void delete(String name) throws SvnException;
}
