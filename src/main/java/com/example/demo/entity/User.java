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

/**
 * ��`���`��� Entity
 */
@Entity
@Data
@Table(name = "user")
public class User implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
   * ID
   */
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  /**
   * ��ǰ
   */
  @Column(name = "name")
  public String name;
  /**
   * ס��
   */
  @Column(name = "address")
  public String address;
  /**
   * �Ԓ����
   */
  @Column(name = "phone")
  public String phone;
  /**
   * �����Օr
   */
  @Column(name = "update_date")
  public Date updateDate;
  /**
   * ���h�Օr
   */
  @Column(name = "create_date")
  public Date createDate;
  /**
   * �����Օr
   */
  @Column(name = "delete_date")
  public Date deleteDate;
}