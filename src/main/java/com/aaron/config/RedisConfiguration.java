package com.aaron.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.collections.RedisList;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Aaron Sheng on 9/18/16.
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfiguration {
    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisProperties.getMaxTotal());
        jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
        jedisPoolConfig.setMinIdle(redisProperties.getMinIdle());
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
        jedisPoolConfig.setTestOnBorrow(redisProperties.getTestOnBorrow());

        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisProperties.getHost());
        factory.setPort(redisProperties.getPort());
        factory.setPassword(redisProperties.getPassword());
        factory.setTimeout(redisProperties.getTimeout());
        factory.setPoolConfig(jedisPoolConfig);
        return factory;
    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(this.redisConnectionFactory());
        return redisTemplate;
    }
}
