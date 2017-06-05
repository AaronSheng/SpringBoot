package com.aaron.redis;

/**
 * Created by Aaron Sheng on 10/10/16.
 */
public interface OnlineUserRedis {
    void setName(final Long id, final String name);

    String getName(final Long id);

    void delete(final Long id);

    int size();
}
