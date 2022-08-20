package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name = "admin")
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	   * ID
	   */
	  @Id
	  @Column(name = "id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  /**
	   * ��ǰ
	   */
	  @Column(name = "name")
	  private String name;
	  /**
	   * ס��
	   */
	  @Column(name = "password")
	  private String password;
	
	}
