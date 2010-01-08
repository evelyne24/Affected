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
public class SvnProjectServiceDefault implements SvnProjectService {
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
