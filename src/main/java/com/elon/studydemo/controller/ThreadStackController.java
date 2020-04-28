package com.elon.studydemo.controller;


import com.elon.studydemo.entity.MsgObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 线程栈溢出
 */
@RestController
@RequestMapping("/stack")
public class ThreadStackController {

    @RequestMapping("/stackOverflow")
    public MsgObj stackOverflow(int num) {
        fn(num);
        return new MsgObj();
    }

    public void fn(int n) {
        if (n == 0) {
            System.out.println("我结束了...");
        } else {
            System.out.println("我是n：" + n);
            n = n + 1;
            fn(n);
        }
    }

}
