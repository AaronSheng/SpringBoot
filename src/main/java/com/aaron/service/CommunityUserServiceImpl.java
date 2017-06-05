package com.aaron.service;

import com.aaron.dao.CommunityUserDao;
import com.aaron.dao.UserDao;
import com.aaron.entity.CommunityUser;
import com.aaron.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Aaron Sheng on 9/9/16.
 */
@Service
@Transactional(value="communityTransactionManager")
public class CommunityUserServiceImpl implements CommunityUserService {
    @Autowired
    private CommunityUserDao communityUserDao;

    public String getName(Long id) {
        return communityUserDao.get(id).getName();
    }

    public void setName(Long id, String name) {
        CommunityUser communityUser = communityUserDao.get(id);
        if (communityUser != null) {
            communityUser.setName(name);
            communityUserDao.update(communityUser);
        }
    }
}
