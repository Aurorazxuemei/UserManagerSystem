package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

/**
 * ��`���`��� Controller
 */
@Controller
public class UserController {

  /**
   * ��`���`��� Service
   */
  @Autowired
  private UserService userService;

  /**
   * ��`���`���һ�E������ʾ
   * @param model Model
   * @return ��`���`���һ�E����
   */
  @GetMapping(value = "/user/list")
  public String displayList(Model model) {
    List<User> userlist = userService.searchAll();
    model.addAttribute("userlist", userlist);
    return "user/list";
  }

  /**
   * ��`���`��Ҏ���h������ʾ
   * @param model Model
   * @return ��`���`���һ�E����
   */
  @GetMapping(value = "/user/add")
  public String displayAdd(Model model) {
    return "user/add";
  }

  /**
   * ��`���`���Ԕ��������ʾ
   * @param id ��ʾ�����`���`ID
   * @param model Model
   * @return ��`���`���Ԕ������
   */
  @GetMapping("/user/{id}")
  public String displayView(@PathVariable Long id, Model model) {
    User user = userService.findById(id);
    model.addAttribute("userData", user);
    return "user/view";
  }
  @GetMapping("/user/{id}/delete")
  public String deleteUser(@PathVariable Long id, Model model) {
    userService.deleteById(id);
    return "redirect:/user/list";
  }
  /**
   * ユーザー編集画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー編集画面
   */
  @GetMapping("/user/{id}/edit")
  public String displayEdit(@PathVariable Long id, Model model) {
	  User user = userService.findById(id);
	    UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
	    userUpdateRequest.setId(user.getId());
	    userUpdateRequest.setName(user.getName());
	    userUpdateRequest.setPhone(user.getPhone());
	    userUpdateRequest.setAddress(user.getAddress());
	    model.addAttribute("userUpdateRequest", userUpdateRequest);
	    return "user/edit";
  }

}