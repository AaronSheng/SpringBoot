package com.aaron.mapper_serv;

import com.aaron.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by aaron on 7/11/17.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where id= #{id}")
    User get(@Param("id") Long id);

    @Select("select name from user where id=#{id}")
    String getName(@Param("id") Long id);

    @Update("update user set name=#{name} where id=#{id}")
    void updateName(@Param("id")Long id, @Param("name")String name);
}
