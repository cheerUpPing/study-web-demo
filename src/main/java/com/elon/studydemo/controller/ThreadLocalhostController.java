package com.elon.studydemo.controller;

import com.elon.studydemo.constant.Constant;
import com.elon.studydemo.entity.MsgObj;
import com.elon.studydemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/thread-local", "/*"})
public class ThreadLocalhostController {

    @RequestMapping("/get-user")
    @ResponseBody
    public MsgObj getUser() {
        return new MsgObj(Constant.getUser());
    }

    @RequestMapping("/get-users")
    @ResponseBody
    public MsgObj getUsers() {
        User user = new User();
        user.setName("秦时明月");
        user.setAge(100);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(Constant.getUser());
        return new MsgObj(users);
    }
}
