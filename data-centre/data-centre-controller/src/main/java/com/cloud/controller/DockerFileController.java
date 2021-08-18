package com.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zuyunbo
 * @Date 2021/8/18  2:42 下午
 **/
@RestController
public class DockerFileController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello,docker";
    }

}
