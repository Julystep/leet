package com.boomshair.springmultidatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author liminglei
 */
@Component
public class DataSource2Config {

    @Bean("dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource datasource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean("sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2(DataSource dataSource2) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath*:mapper/db2/*.xml"));
        bean.setDataSource(dataSource2);
        return bean.getObject();
    }

}
