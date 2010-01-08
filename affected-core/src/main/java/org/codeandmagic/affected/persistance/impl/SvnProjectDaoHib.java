package org.codeandmagic.affected.persistance.impl;

import org.codeandmagic.affected.persistance.api.SvnProjectDao;
import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.svn.api.SvnProject;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class SvnProjectDaoHib extends GenericDaoHib implements SvnProjectDao {

    public SvnProject get(String name) throws SvnException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SvnProject.class);
        criteria.add(Restrictions.eq("name", name));
        List<SvnProject> results = criteria.list();
        if (results == null || results.size() == 0) {
            throw new SvnException("No SvnProject with name '" + name + "'");
        }
        return results.get(0);
    }

    public List<SvnProject> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(SvnProject.class).list();
    }

    public void save(SvnProject project) {
        sessionFactory.getCurrentSession().saveOrUpdate(project);
    }

    public void delete(SvnProject project) {
        sessionFactory.getCurrentSession().delete(project);
    }
}
