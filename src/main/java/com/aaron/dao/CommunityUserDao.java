package com.aaron.dao;

import com.aaron.dao.base.GenericDao;
import com.aaron.domain.CommunityUser;

/**
 * Created by Aaron Sheng on 9/16/16.
 */
public interface CommunityUserDao extends GenericDao<CommunityUser, Long> {
    CommunityUser get(Long id);

    void add(CommunityUser communityUser);
}
