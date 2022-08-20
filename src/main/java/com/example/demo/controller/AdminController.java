package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    return "admin/add";
  }

  /**
   * ��`���`���Ԕ��������ʾ
   * @param id ��ʾ�����`���`ID
   * @param model Model
   * @return ��`���`���Ԕ������
   */
//  @GetMapping("/user/{id}")
//  public String displayView(@PathVariable Long id, Model model) {
//	  Admin user = adminService.findById(id);
//    model.addAttribute("userData", user);
//    return "user/view";
//  }
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
 // @GetMapping("/user/{id}/edit")
//  public String displayEdit(@PathVariable Long id, Model model) {
//	  Admin user = adminService.findById(id);
//	    AdminUpdateRequest userUpdateRequest = new AdminUpdateRequest();
//	    userUpdateRequest.setId(user.getId());
//	    userUpdateRequest.setName(user.getName());
//	    userUpdateRequest.setPhone(user.getPhone());
//	    userUpdateRequest.setAddress(user.getAddress());
//	    model.addAttribute("userUpdateRequest", userUpdateRequest);
//	    return "user/edit";
//  }

}