package com.elon.studydemo.controller;

import com.alibaba.fastjson.JSON;
import com.elon.studydemo.entity.MsgObj;
import com.elon.studydemo.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request/param")
public class RequestParamController {

    @RequestMapping("/queryUser")
    public MsgObj queryUser(String userJson){
        if (StringUtils.isBlank(userJson)){
            return new MsgObj("参数不能为空");
        }
        User user = JSON.parseObject(userJson, User.class);
        return new MsgObj(user);
    }

    @RequestMapping("/queryUserObj")
    public MsgObj queryUserObj(@RequestBody User user){
        System.out.println("====" + user.getName() + " ===" + user.getAge());
        return new MsgObj(user);
    }
}
