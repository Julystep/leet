package com.example.springaop.config;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author: liml
 * @date: 2022/5/18
 */
public interface DynamicDataSourceProvider {

    String DEFAULT_DATASOURCE = "master";

    Map<String, DataSource> loadDataSources();

}
