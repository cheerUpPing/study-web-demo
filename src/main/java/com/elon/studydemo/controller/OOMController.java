package com.elon.studydemo.controller;

import com.elon.studydemo.ann.LoginRequired;
import com.elon.studydemo.entity.MsgObj;
import com.elon.studydemo.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * oom分为：<br/>
 *     1.年轻代、年老代溢出 java.lang.OutOfMemoryError: Java heap space <br/>
 *     2.永久代溢出 java.lang.OutOfMemoryError: PermGen space <br/>
 */
@RestController
@RequestMapping("/oom")
public class OOMController {

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));

    @RequestMapping("/test/{num}")
    @LoginRequired
    public MsgObj test(@PathVariable int num){
        final List<User> users = Collections.synchronizedList(new ArrayList<User>());
        for (int i = 0; i < num; i++){
            users.add(new User("名字:" + i, i));
        }
        System.out.println("========================");
        return new MsgObj(users);
    }

    @RequestMapping("/test")
    public MsgObj test(){
        final List<User> users = Collections.synchronizedList(new ArrayList<User>());
        for (int i = 0; i < 10; i++){
            // 线程名字
            final int finalI = i;
            Thread thread = new Thread(){
                @Override
                public void run() {
                    for (int j = finalI; ; j++){
                        users.add(new User(this.getName(), j));
                    }
                }
            };
            thread.setName("thread_name_" + i);
            // 执行线程
            threadPoolExecutor.submit(thread);
        }
        System.out.println("========================");
        return new MsgObj();
    }

}
