package com.aaron.service;

import com.aaron.redis.OnlineUserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aaron Sheng on 10/6/16.
 */
@Service
public class OnlineUserServiceImpl implements OnlineUserService {
    @Autowired
    private OnlineUserRedis onlineUserRedis;

    public String getName(Long id) {
        return onlineUserRedis.getName(id);
    }

    public void setName(Long id, String name) {
        onlineUserRedis.setName(id, name);
    }
}
