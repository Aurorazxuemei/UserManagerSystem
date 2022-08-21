package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

@Controller
public class HelloWorldController {
	
	  @Autowired
	  private AdminService adminService;
	  
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(Model model) {
    	Admin admin = new Admin();
        model.addAttribute("admin111", admin);
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login( Admin admin, Model model) {
    	String name = admin.getName();
		String password = admin.getPassword();
		
    	List<Admin> adminlist = adminService.searchAll();
    	
    	Boolean isSussed = false;
    	
    	for ( Admin adm :  adminlist) {
    		
    		String name1 = adm.getName();
    		String password1 = adm.getPassword();
    		
    		if(name.equals(name1) && password.equals(password1)) {
    			isSussed = true;
    			break;
    		}
	       
	    }
    	
    	if(isSussed) {
    		
    	}else {
    		model.addAttribute("admin111", admin);
    		model.addAttribute("loginError", "登録に失敗しました！");
    		return "index";
    	}
    	return "";
    }
}