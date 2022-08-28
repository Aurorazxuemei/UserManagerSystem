package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

public class MyUserDetailsService implements UserDetailsService{

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Autowired
    private AdminService adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Admin admin = adminRepository.findByName(username);
        if (admin == null) {
            throw new UsernameNotFoundException(username);
        }
        return admin;
    }

}
