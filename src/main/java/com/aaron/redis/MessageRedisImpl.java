package com.aaron.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Aaron Sheng on 10/6/16.
 */
@Repository
public class MessageRedisImpl implements MessageRedis {
    private static final String MESSAGE = "message";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public  Long add(String message) {
        return redisTemplate.opsForList().rightPush(MESSAGE, message);
    }

    public String get() {
        return redisTemplate.opsForList().leftPop(MESSAGE);
    }

    public Long size() {
        return redisTemplate.opsForList().size(MESSAGE);
    }
}
