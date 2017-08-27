package com.aaron.mapper.dynamic;

import com.aaron.config.TargetDataSource;
import com.aaron.domain.User;
import com.aaron.mapper.dynamic.DynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Aaron Sheng on 2017/8/27.
 */
@Component
public class DynamicDao {
    @Autowired
    private DynamicMapper dynamicMapper;

    @TargetDataSource("mybatisServerDataSource")
    public User get(Long id) {
        return dynamicMapper.get(id);
    }
}
