package org.codeandmagic.affected.persistence.hibernate;

import java.util.List;

import org.codeandmagic.affected.persistence.SvnProjectDao;
import org.codeandmagic.affected.svn.SvnException;
import org.codeandmagic.affected.svn.SvnProject;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class SvnProjectDaoHib extends GenericDaoHib implements SvnProjectDao {

	@SuppressWarnings("unchecked")
	public SvnProject get(String name) throws SvnException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				SvnProject.class);
		criteria.add(Restrictions.eq("name", name));
		List<SvnProject> results = criteria.list();
		if (results == null || results.size() == 0) {
			throw new SvnException("No SvnProject with name '" + name + "'");
		}
		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<SvnProject> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(
				SvnProject.class).list();
	}

	public boolean save(SvnProject project) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(project);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean delete(SvnProject project) {
		try {
			sessionFactory.getCurrentSession().delete(project);
			return true;
		} catch (HibernateException e) {
			return false;
		}

	}
}
