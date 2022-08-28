package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
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
  
  public Admin findByName(String name) {
	  List<Admin> adminlist = searchAll();
  	
  	for ( Admin adm :  adminlist) {
  		
  		
  		if(name.equals(adm.getUsername())) {
  			return adm;
  		}
	       
	    }
	    return null;
 }
  
  public void deleteById(Long id) {
	  adminRepository.deleteById(id);
  
  }
  
  public void create(Admin admin) {
//	    Date now = new Date();
//	    User user = new User();
//	    user.setName(userRequest.getName());
//	    user.setAddress(userRequest.getAddress());
//	    user.setPhone(userRequest.getPhone());
//	    user.setCreateDate(now);
//	    user.setUpdateDate(now);
	    adminRepository.save(admin);
	  }

  public void update(Admin admin) {
//	  Admin admin = findById(admin.getId());
	   
	    adminRepository.save(admin);
	  }
}