package com.aaron.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron Sheng on 2017/8/27.
 */
@Configuration
@MapperScan(basePackages = "com.aaron.mapper.dynamic", sqlSessionFactoryRef = "mybatisDynamicSesstionFactory")
public class MyBatisDynamicConfiguration {

    @Bean
    @Qualifier(value = "dynamicDataSouce")
    public DataSource dynamicDataSouce(@Qualifier("mybatisCommunityDataSource")DataSource commDataSource,
                                       @Qualifier("mybatisServerDataSource") DataSource servDataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(servDataSource);
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("mybatisCommunityDataSource", commDataSource);
        targetDataSources.put("mybatisServerDataSource", servDataSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

    @Bean
    @Qualifier(value = "mybatisDynamicSesstionFactory")
    public SqlSessionFactory mybatisDynamicSesstionFactory(@Qualifier("dynamicDataSouce")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }
}
