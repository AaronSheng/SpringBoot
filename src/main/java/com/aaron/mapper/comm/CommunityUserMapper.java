package com.aaron.mapper.comm;

import com.aaron.domain.CommunityUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by aaron on 7/11/17.
 */
@Mapper
public interface CommunityUserMapper {
    @Select("select * from communityuser where id=#{id}")
    CommunityUser get(@Param("id")Long id);

    @Select("select name from communityuser where id=#{id}")
    String getName(@Param("id")Long id);

    @Update("update communityuser set name=#{name} where id=#{id}")
    void updateName(@Param("id")Long id, @Param("name")String name);
}
