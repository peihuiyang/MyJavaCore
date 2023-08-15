package com.peihui.webserver.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "健康检查",tags = "健康检查")
@RestController
@RequestMapping("/health")
public class HealthController {

    @ApiOperation(value = "测试")
    @GetMapping("/test")
    public String test(){
        return "Hello World!";
    }
}
