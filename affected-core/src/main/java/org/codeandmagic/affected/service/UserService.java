package org.codeandmagic.affected.service;

import java.util.List;

import org.codeandmagic.affected.svn.SvnException;
import org.codeandmagic.affected.user.User;

/**
 *
 */
public interface UserService {
	User get(String username) throws SvnException;

	List<User> getAll();

	User create(String username, String password);

	boolean save(User user);

	boolean delete(String username) throws SvnException;
}
