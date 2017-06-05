package com.aaron.service;

import com.aaron.redis.RankRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Aaron Sheng on 10/7/16.
 */
@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankRedis rankRedis;

    @Override
    public void addScore(Long id, Long userId) {
        rankRedis.addScore(id, userId);
    }

    @Override
    public Long getRank(Long score) {
        return rankRedis.getRank(score);
    }

    @Override
    public void deleteRank(Long id) {
        rankRedis.deleteRank(id);
    }
}
