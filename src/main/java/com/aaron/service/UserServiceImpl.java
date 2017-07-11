package com.aaron.service;

import com.aaron.dao.UserDao;
import com.aaron.dao.UserMapper;
import com.aaron.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Aaron Sheng on 9/9/16.
 */
@Service
//@Transactional(value="serverTransactionManager")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    public String getName(Long id) {
        return userMapper.getName(id);
    }

    public void setName(Long id, String name) {
        userMapper.updateName(id, name);
    }
}
