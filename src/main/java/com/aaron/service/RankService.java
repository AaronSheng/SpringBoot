package com.aaron.service;

/**
 * Created by Aaron Sheng on 10/7/16.
 */
public interface RankService {
    public void addScore(Long id, Long score);

    public Long getRank(Long score);

    public void deleteRank(Long id);
}
