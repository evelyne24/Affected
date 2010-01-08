package org.codeandmagic.affected.service.impl;

import org.codeandmagic.affected.persistance.api.SvnProjectDao;
import org.codeandmagic.affected.service.api.SvnProjectService;
import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SvnProjectServiceJdbc implements SvnProjectService {
    private SvnProjectDao dao;

    @Required
    @Autowired
    public void setDao(SvnProjectDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    public SvnProject get(String url) throws SvnException {
        return dao.get(url);
    }

    @Transactional(readOnly = true)
    public List<SvnProject> getAllProjects() {
        return dao.getAllProjects();
    }

    @Transactional(readOnly = false)
    public SvnProject create(String url, long localVersion, String username, String password) throws SvnException {
        return dao.create(url, localVersion, username, password);
    }

    @Transactional(readOnly = false)
    public void update(SvnProject project) {
        dao.update(project);
    }

    @Transactional(readOnly = false)
    public void delete(String url) {
        dao.delete(url);
    }
}
