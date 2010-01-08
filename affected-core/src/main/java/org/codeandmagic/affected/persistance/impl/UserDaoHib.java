package org.codeandmagic.affected.persistance.impl;

import org.codeandmagic.affected.persistance.api.UserDao;
import org.codeandmagic.affected.svn.api.SvnException;
import org.codeandmagic.affected.user.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public class UserDaoHib extends GenericDaoHib implements UserDao {

    public User get(String username) throws SvnException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        List<User> results = criteria.list();
        if (results == null || results.size() == 0) {
            throw new SvnException("No User with username '" + username + "'.");
        }
        return results.get(0);
    }

    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    public User create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        save(user);
        return user;
    }

    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }
}
