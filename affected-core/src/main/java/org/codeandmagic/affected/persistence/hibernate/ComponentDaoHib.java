package org.codeandmagic.affected.persistence.hibernate;

import java.util.Collection;
import java.util.List;

import org.codeandmagic.affected.component.Component;
import org.codeandmagic.affected.persistence.ComponentDao;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentDaoHib extends GenericDaoHib implements ComponentDao {

	public Component get(int id) {
		return (Component) getSession().get(Component.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Component> getAll() {
		return getSession().createCriteria(Component.class).list();
	}

	public Component getByTag(String tag) {
		return (Component) getSession().createCriteria(Component.class).add(
				Restrictions.eq("tag", tag)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Component> getByTags(Collection<Component> tags) {
		return getSession().createCriteria(Component.class).add(
				Restrictions.in("tag", tags)).list();
	}

	public boolean save(Component component) {
		try {
			getSession().save(component);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean delete(Component component) {
		try {
			getSession().delete(component);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
}
