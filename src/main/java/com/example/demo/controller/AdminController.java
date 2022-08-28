package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

/**
 * ��`���`��� Controller
 */
@Controller
public class AdminController {

  /**
   * ��`���`��� Service
   */
  @Autowired
  private AdminService adminService;

  /**
   * ��`���`���һ�E������ʾ
   * @param model Model
   * @return ��`���`���һ�E����
   */
  @GetMapping(value = "/admin/list")
  public String displayList(Model model) {
    List<Admin> adminlist = adminService.searchAll();
    model.addAttribute("adminlist", adminlist);
    return "admin/list";
  }

  /**
   * ��`���`��Ҏ���h������ʾ
   * @param model Model
   * @return ��`���`���һ�E����
   */
  @GetMapping(value = "/admin/add")
  public String displayAdd(Model model) {
	  BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
	  String ss = encoder.encode("ffffff".trim());
	  
	  Admin admin = new Admin();
    model.addAttribute("admin222", admin);
    return "admin/add";
  }
  
  @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
  public String create(Admin admin, Model model) {

    // ユーザー情報の登録
    adminService.create(admin);
    return "redirect:/admin/list";
  }
  /**
   * ��`���`���Ԕ��������ʾ
   * @param id ��ʾ�����`���`ID
   * @param model Model
   * @return ��`���`���Ԕ������
   *///master
  @GetMapping("/admin/{id}")
  public String displayView(@PathVariable Long id, Model model) {
	  Admin admin = adminService.findById(id);
    model.addAttribute("admin", admin);
    return "admin/view";
  }
//  @GetMapping("/user/{id}/delete")
//  public String deleteUser(@PathVariable Long id, Model model) {
//	  adminService.deleteById(id);
//    return "redirect:/user/list";
//  }
  /**
   * ユーザー編集画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー編集画面
   */
  @GetMapping("/admin/{id}/edit")
  public String displayEdit(@PathVariable Long id, Model model) {
	  Admin admin = adminService.findById(id);
	
	    model.addAttribute("admin333", admin);
	    return "admin/edit";
  }
  
  
  
  @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
  public String update( Admin admin, Model model) {
	 
    // ユーザー情報の更新
    adminService.update(admin);
    //"redirect:/admin/2"
//    String s = "redirect:/admin/";
//    s += admin.getId();
//    return s;
    
    return String.format("redirect:/admin/%d", admin.getId());
  }
}