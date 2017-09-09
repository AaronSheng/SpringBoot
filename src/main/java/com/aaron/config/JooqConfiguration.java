package com.aaron.config;

import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by Aaron Sheng on 2017/9/9.
 */
@Configuration
@AutoConfigureAfter(HibernateConfiguration.class)
public class JooqConfiguration {

    @Bean
    @Qualifier(value = "serverDSLContext")
    @Primary
    public DSLContext serverDSLContext(@Qualifier("serverDataSource") DataSource dataSource) {
        ConnectionProvider connectionProvider = new DataSourceConnectionProvider(dataSource);
        org.jooq.Configuration configuration = new DefaultConfiguration()
                .set(connectionProvider)
                .set(SQLDialect.MYSQL);
        return DSL.using(configuration);
    }

    @Bean
    @Qualifier(value = "communityDSLContext")
    @Primary
    public DSLContext communityDSLContext(@Qualifier("communityDataSource") DataSource dataSource) {
        ConnectionProvider connectionProvider = new DataSourceConnectionProvider(dataSource);
        org.jooq.Configuration configuration = new DefaultConfiguration()
                .set(connectionProvider)
                .set(SQLDialect.MYSQL);
        return DSL.using(configuration);
    }
}
