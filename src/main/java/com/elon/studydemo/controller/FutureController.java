package com.elon.studydemo.controller;

import com.elon.studydemo.entity.MsgObj;
import com.elon.studydemo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

@RestController
@RequestMapping(value = "/future")
public class FutureController {

    @RequestMapping("/get-future")
    @ResponseBody
    public MsgObj getFuture() throws ExecutionException, InterruptedException {
        FutureThread futureThread = new FutureThread();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<List<User>> future = executorService.submit(futureThread);
        List<User> users = future.get();
        System.out.println("=========================");
        return new MsgObj(users);
    }
}

class FutureThread implements Callable<List<User>> {

    @Override
    public List<User> call() throws Exception {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(i);
            user.setName(UUID.randomUUID().toString());
            users.add(user);
            Thread.sleep(500);
        }
        return users;
    }
}
