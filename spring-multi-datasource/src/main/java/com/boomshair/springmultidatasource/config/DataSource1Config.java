package com.boomshair.springmultidatasource.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


/**
 * @author liminglei
 */
@Configuration
public class DataSource1Config {

    @Bean("dataSource1")
    @ConfigurationProperties("spring.datasource.db1")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean("sqlSessionFactory1")
    public SqlSessionFactory sqlSessionFactory1(DataSource dataSource1) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath:mapper/db1/*.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource1);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate1(SqlSessionFactory sqlSessionFactory1) {
        return new SqlSessionTemplate(sqlSessionFactory1);
    }
}
