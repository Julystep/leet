package com.example.springaop.anno;

import com.example.springaop.config.DynamicDataSourceProvider;
import org.springframework.core.annotation.AliasFor;

/**
 * @author: liml
 * @date: 2022/5/18
 */
public @interface DataSourceAnno {

    String dataSourceName() default DynamicDataSourceProvider.DEFAULT_DATASOURCE;

}
