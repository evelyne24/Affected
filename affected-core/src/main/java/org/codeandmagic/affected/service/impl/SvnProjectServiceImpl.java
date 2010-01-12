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

package org.codeandmagic.affected.service.impl;

import java.util.List;

import org.codeandmagic.affected.persistence.SvnProjectDao;
import org.codeandmagic.affected.service.SvnProjectService;
import org.codeandmagic.affected.svn.SvnException;
import org.codeandmagic.affected.svn.SvnProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SvnProjectServiceImpl implements SvnProjectService {
	private SvnProjectDao dao;

	@Required
	@Autowired
	public void setDao(SvnProjectDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public SvnProject get(String name) throws SvnException {
		return dao.get(name);
	}

	@Transactional(readOnly = true)
	public List<SvnProject> getAll() {
		return dao.getAll();
	}

	@Transactional(readOnly = false)
	public SvnProject create(String name, String url, long lastCheckedVersion) throws SvnException {
		SvnProject proj = new SvnProject();
		proj.setName(name);
		proj.setUrl(url);
		proj.setLastCheckedVersion(lastCheckedVersion);
		save(proj);
		return proj;
	}

	@Transactional(readOnly = false)
	public void save(SvnProject project) {
		dao.save(project);
	}

	@Transactional(readOnly = false)
	public void delete(String name) throws SvnException {
		dao.delete(dao.get(name));
	}
}
