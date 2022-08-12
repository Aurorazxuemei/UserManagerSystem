package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

/**
 * ��`���`��� Service
 */
@Service
public class UserService {
  /**
   * ��`���`��� Repository
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * ��`���`��� ȫ����
   * @return �����Y��
   */
  public List<User> searchAll() {
    return userRepository.findAll();
  }

  /**
   * ��`���`��� �����`����
   * @return �����Y��
   */
  public User findById(Long id) {
    return userRepository.findById(id).get();
  }
  public void deleteById(Long id) {
	  userRepository.deleteById(id);
  
  }
}