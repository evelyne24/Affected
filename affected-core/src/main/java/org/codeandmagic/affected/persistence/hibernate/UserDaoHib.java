/*******************************************************************************
 * Copyright© 2010 Cristian Vrabie, Evelina Petronela Vrabie
 *   
 * This file is part of Affected.
 *   
 * Affected is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, 
 * or (at your option) any later version.
 *   
 * Affected is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied   warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU Lesser General Public License for more details.
 *   
 * You should have received a copy of the GNU Lesser General Public License
 * along with Affected.  If not, see <http://www.gnu.org/licenses/>
 ******************************************************************************/
package org.codeandmagic.affected.persistence.hibernate;

import java.util.List;

import org.codeandmagic.affected.persistence.UserDao;
import org.codeandmagic.affected.svn.SvnException;
import org.codeandmagic.affected.user.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public class UserDaoHib extends GenericDaoHib implements UserDao {

	@SuppressWarnings("unchecked")
	public User get(String username) throws SvnException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		criteria.add(Restrictions.eq("username", username));
		List<User> results = criteria.list();
		if (results == null || results.size() == 0) {
			throw new SvnException("No User with username '" + username + "'.");
		}
		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(User.class)
				.list();
	}

	public User create(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		save(user);
		return user;
	}

	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
}
