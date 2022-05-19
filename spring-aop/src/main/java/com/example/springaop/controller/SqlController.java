package com.example.springaop.controller;

import com.example.springaop.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liml
 * @Date: 2022/5/18
 */
@RestController
public class SqlController {

    MyService myService;

    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("master")
    public void master() {
        myService.checkMasterNumber();
    }

    @GetMapping("slave")
    public void slave() {
        myService.checkSlaveNumber();
    }

}
