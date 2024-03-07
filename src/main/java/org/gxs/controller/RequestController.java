package org.gxs.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.gxs.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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
        System.out.println(user.getUserName()+" : "+user.getAge());
        return "ok";
    }

    //复杂实体
    @RequestMapping("/simpleParam5")
    public String simpleParam5(User user){
        System.out.println(user.getUserName()+" : "+user.getAge()+" : "+user.getAddress());
        return "ok";
    }

    //数组参数
    @RequestMapping("/simpleParam6")
    public String simpleParam6(String [] hobby){
        System.out.println(Arrays.toString(hobby));
        return "ok";
    }

    //集合参数,默认多个值是封装到数组中的,如果指定集合则要加上@RequestParam
    @RequestMapping("/simpleParam7")
    public String simpleParam6(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "ok";
    }
}
