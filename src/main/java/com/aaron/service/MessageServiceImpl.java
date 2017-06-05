package com.aaron.service;

import com.aaron.redis.MessageRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aaron Sheng on 10/6/16.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRedis messageRedis;

    public String getMessage() {
        return messageRedis.get();
    }

    public void addMessage(String message) {
        messageRedis.add(message);
    }
}
