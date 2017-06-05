package com.aaron.service;

import com.aaron.dao.UserDao;
import com.aaron.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Aaron Sheng on 9/9/16.
 */
@Service
@Transactional(value="serverTransactionManager")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public String getName(Long id) {
        return userDao.get(id).getName();
    }

    public void setName(Long id, String name) {
        User user = userDao.get(id);
        if (user != null) {
            user.setName(name);
            userDao.update(user);
        }
    }
}
