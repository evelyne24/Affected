package org.codeandmagic.affected.service.api;

import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.user.User;

import java.util.List;

/**
 *
 */
public interface UserService {
    User get(String username) throws SvnException;

    List<User> getAll();

    User create(String username, String password);

    void save(User user);

    void delete(String username) throws SvnException;
}
