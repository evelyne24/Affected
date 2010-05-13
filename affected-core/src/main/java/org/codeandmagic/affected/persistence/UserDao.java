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

	void save(User user);

	void delete(User user);
}
