package org.codeandmagic.affected.persistance.api;

import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.user.User;

import java.util.List;

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
