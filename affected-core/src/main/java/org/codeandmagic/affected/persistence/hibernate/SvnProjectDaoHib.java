package org.codeandmagic.affected.persistence.hibernate;

import java.util.List;

import org.codeandmagic.affected.persistence.SvnProjectDao;
import org.codeandmagic.affected.svn.SvnProject;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class SvnProjectDaoHib extends GenericDaoHib implements SvnProjectDao {

	public SvnProject get(int id) {
		return (SvnProject) sessionFactory.getCurrentSession().get(
				SvnProject.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<SvnProject> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(
				SvnProject.class).list();
	}

	public void save(SvnProject project) {
		sessionFactory.getCurrentSession().saveOrUpdate(project);
	}

	public void delete(SvnProject project) {
		sessionFactory.getCurrentSession().delete(project);
	}
}
