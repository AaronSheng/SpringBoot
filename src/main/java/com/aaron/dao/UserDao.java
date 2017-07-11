package com.aaron.dao;

import com.aaron.domain.User;
import com.aaron.dao.base.GenericDao;

/**
 * Created by Aaron Sheng on 9/16/16.
 */
public interface UserDao extends GenericDao<User, Long> {
    User get(Long id);

    void add(User user);

    void update(User user);
}
