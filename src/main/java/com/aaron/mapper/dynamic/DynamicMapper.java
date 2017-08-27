package com.aaron.mapper.dynamic;

import com.aaron.config.TargetDataSource;
import com.aaron.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Aaron Sheng on 2017/8/27.
 */
@Mapper
public interface DynamicMapper {
    @Select("select * from user where id= #{id}")
    User get(@Param("id") Long id);
}
