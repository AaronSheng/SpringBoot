package com.aaron.redis;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Aaron Sheng on 10/10/16.
 */
public interface RankRedis {
    Boolean addScore(Long userId, Long score);

    Long getRank(Long score);

    void deleteRank(Long userId);

    Set<Long> getAllScore();

    List<RankRedisImpl.RankTuple> getAllRank();

    Long size() ;

    public static class RankTuple {
        private final Long userId;
        private final Long score;

        public RankTuple(Long score, Long userId) {
            this.score = score;
            this.userId = userId;
        }

        public Long getScore() {
            return score;
        }

        public Long getUserId() {
            return userId;
        }
    }
}
