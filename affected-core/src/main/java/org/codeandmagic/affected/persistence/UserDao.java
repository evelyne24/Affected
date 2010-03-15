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
package org.codeandmagic.affected.persistence;

import java.util.List;

import org.codeandmagic.affected.svn.SvnException;
import org.codeandmagic.affected.user.User;

/**
 *
 */
// @affects: UserService, SvnProjectController
public interface UserDao {
	User get(String username) throws SvnException;

	List<User> getAll();

	User create(String username, String password);

	boolean save(User user);

	boolean delete(User user);
}
