package com.aaron.redis;

/**
 * Created by Aaron Sheng on 10/10/16.
 */
public interface MessageRedis {
    Long add(String message);

    String get();

    Long size();
}
