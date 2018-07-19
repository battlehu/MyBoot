/**
 * 
 */
package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class HelloController {

	/*
	 * 如果是@RestController要用下面这种方法，否则无法访问
	 * 这种方法可以返回页面，也可以返回字符串
	 * http://localhost:9090/hello/test
	 */
    @RequestMapping("/test")
    public ModelAndView hello() {
    	 ModelAndView mv = new ModelAndView("index");     
    	 return mv; 
    }
    
    /*
	 * 如果是@RestController要用下面这种方法，否则无法访问
	 * http://localhost:9090/hello/testrep
	 */
    @RequestMapping("/testrep")
    public void hello1(HttpServletResponse response) throws IOException {
    	response.sendRedirect("test"); 
    	//return "redirect:/hello/test";
    }
    
    /*
	 * 如果是@Controller用上面和下面这两种方法都可以访问
	 * 但是只能返回页面
	 * http://localhost:9090/hello/testStr
	 */
    @RequestMapping("/testStr")
    public String hello2() {	     
    	 return "index";
    }
     
    //http://localhost:9090/hello/info?name="laosiji"
    @RequestMapping("/info")
    public Map<String, String> getInfo(@RequestParam String name) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return map;
    }

    /*
	 * 如果想返回数据要用@RestController
	 * http://localhost:9090/hello/list
	 */
    @RequestMapping("/list")
    public List<Map<String, String>> getList() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = null;
        for (int i = 1; i <= 5; i++) {
            map = new HashMap<>();
            map.put("name", "Shanhy-" + i);
            list.add(map);
        }
        return list;
    }
    
}