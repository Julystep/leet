package com.example.springaop.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: liml
 * @date: 2022/5/18
 */
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
@Slf4j
public class DynamicDataSourceProviderImpl implements DynamicDataSourceProvider{

    DataSourceProperties dataSourceProperties;

    @Autowired
    public void setDataSource(DataSourceProperties dataSource) {
        this.dataSourceProperties = dataSource;
    }

    @Override
    public Map<String, DataSource> loadDataSources() {
        Map<String, DataSource> ds = new HashMap<>(dataSourceProperties.getDs().size());
        Map<String, Map<String, String>> map = dataSourceProperties.getDs();
        for (String s : map.keySet()) {
            try {
                DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(map.get(s));
                ds.put(s, dataSourceProperties.dataSource(dataSource));
            } catch (Exception e) {
                log.error("创建数据源异常" + e);
            }
        }
        return ds;
    }
}
