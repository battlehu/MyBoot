/**
 * 
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * @author LOL
 * 2017年12月13日下午3:43:51
 */
@Controller
@RequestMapping("/redirect")
public class WebController {

   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login() {
       return "login";
   }
   
   @RequestMapping(value = "/addEmp", method = RequestMethod.GET)
   public String addEmp() {
       return "addEmp";
   }
   
   @RequestMapping(value = "/out", method = RequestMethod.GET)
   public String out() {
       return "out";
   }
   
   @RequestMapping(value = "/updateEmp", method = RequestMethod.GET)
   public String updateEmp() {
       return "updateEmp";
   }
   
   @RequestMapping(value = "/regist", method = RequestMethod.GET)
   public String regist() {
       return "regist";
   }
}
