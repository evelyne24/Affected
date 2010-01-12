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

import org.codeandmagic.affected.persistence.UserDao;
import org.codeandmagic.affected.service.UserService;
import org.codeandmagic.affected.svn.SvnException;
import org.codeandmagic.affected.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Service
public class UserServiceImpl implements UserService {
	private UserDao dao;

	@Required
	@Autowired
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public User get(String username) throws SvnException {
		return dao.get(username);
	}

	@Transactional(readOnly = true)
	public List<User> getAll() {
		return dao.getAll();
	}

	@Transactional(readOnly = false)
	public User create(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		save(user);
		return user;
	}

	@Transactional(readOnly = false)
	public void save(User user) {
		dao.save(user);
	}

	@Transactional(readOnly = false)
	public void delete(String username) throws SvnException {
		dao.delete(dao.get(username));
	}
}
