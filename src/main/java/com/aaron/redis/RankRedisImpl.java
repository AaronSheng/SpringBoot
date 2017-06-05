package com.aaron.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Aaron Sheng on 10/7/16.
 */
@Repository
public class RankRedisImpl implements RankRedis {
    private static final String RANK = "rank";

    @Autowired
    private RedisTemplate<String, Long> redisTemplate;

    public Boolean addScore(Long userId, Long score) {
        return redisTemplate.opsForZSet().add(RANK, userId, score);
    }

    public Long getRank(Long score) {
        getAllRank();
        return redisTemplate.opsForZSet().rank(RANK, score);
    }

    public void deleteRank(Long userId) {
        redisTemplate.opsForZSet().remove(RANK, userId);
    }

    public Set<Long> getAllScore() {
        return redisTemplate.opsForZSet().range(RANK, 0, -1);
    }

    public List<RankTuple> getAllRank() {
        List<RankTuple> rankTuples = new ArrayList<RankTuple>();
        Set<ZSetOperations.TypedTuple<Long>> set = redisTemplate.opsForZSet().rangeWithScores(RANK, 0, -1);
        for (ZSetOperations.TypedTuple<Long> typedTuple : set) {
            rankTuples.add(new RankTuple(typedTuple.getValue(), typedTuple.getScore().longValue()));
        }
        return rankTuples;
    }

    public Long size() {
        return redisTemplate.opsForZSet().size(RANK);
    }
}
