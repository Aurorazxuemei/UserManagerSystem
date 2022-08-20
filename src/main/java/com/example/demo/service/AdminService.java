package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UserRepository;

/**
 * ��`���`��� Service
 */
@Service
public class AdminService {
  /**
   * ��`���`��� Repository
   */
  @Autowired
  private AdminRepository adminRepository;

  /**
   * ��`���`��� ȫ����
   * @return �����Y��
   */
  public List<Admin> searchAll() {
    return adminRepository.findAll();
  }

  /**
   * ��`���`��� �����`����
   * @return �����Y��
   */
  public Admin findById(Long id) {
    return adminRepository.findById(id).get();
  }
  public void deleteById(Long id) {
	  adminRepository.deleteById(id);
  
  }
}