package org.codeandmagic.affected.service.impl;

import java.util.List;

import org.codeandmagic.affected.persistence.SvnProjectDao;
import org.codeandmagic.affected.service.SvnProjectService;
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
	public SvnProject get(int id) {
		return dao.get(id);
	}

	@Transactional(readOnly = true)
	public List<SvnProject> getAll() {
		return dao.getAll();
	}

	@Transactional(readOnly = false)
	public SvnProject create(String name, String url, long lastCheckedVersion) {
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
	public void delete(int id) {
		dao.delete(dao.get(id));
	}
}
