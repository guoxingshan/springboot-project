package org.gxs.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.gxs.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    //原始的请求方式，在不指定请求方法时，get post都可以
    @RequestMapping("/simpleParam")
    public String simpleParam(HttpServletRequest request){
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        
        int age = Integer.parseInt(ageStr);
        System.out.println("age: "+age);
        return "ok";
    }

    //springboot简化后的请求方式
    @RequestMapping("/simpleParam1")
    public String simpleParam1(String name,Integer age){
        System.out.println("age: "+age);
        return "ok";
    }

    //形参可以跟请求参数不一致,默认必须客户端必须传递该参数
    @RequestMapping("/simpleParam2")
    public String simpleParam2(@RequestParam(name="name") String userName, Integer age){
        System.out.println(userName+" : "+age);
        return "ok";
    }

    //形参可以跟请求参数不一致,客户端可以不传递该参数
    @RequestMapping("/simpleParam3")
    public String simpleParam3(@RequestParam(name="name",required = false) String userName, Integer age){
        System.out.println(userName+" : "+age);
        return "ok";
    }

    //实体参数
    @RequestMapping("/simpleParam4")
    public String simpleParam4(User user){
        System.out.println(user.userName+" : "+user.age);
        return "ok";
    }
}
