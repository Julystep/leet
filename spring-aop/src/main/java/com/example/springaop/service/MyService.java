package com.example.springaop.service;

import com.example.springaop.anno.DataSourceAnno;
import com.example.springaop.mapper.MyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: liml
 * @date: 2022/5/18
 */
@Service
@Slf4j
public class MyService {

    MyMapper myMapper;

    @Autowired
    public void setMyMapper(MyMapper mapper) {
        this.myMapper = mapper;
    }

    @DataSourceAnno
    public void checkMasterNumber() {
        log.info("" + myMapper.select());
    }

    @DataSourceAnno(dataSourceName = "slave")
    public void checkSlaveNumber() {
        log.info("" + myMapper.select());
    }

}
