package com.saltedfish.demogradleservice.controller;

import com.saltedfish.demogradleservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pengchongchong on 17-12-8.
 */
@RestController
public class Controller {

    @Autowired
    private HelloService helloService;
    @RequestMapping(value = "/sayHello", method = {RequestMethod.GET}, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String sayHello(@ModelAttribute("name") String name) {
        return helloService.sayHello(name);
    }
}
