package com.pzy.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
/***
 *工资
 */
@Entity
@Table(name = "t_pay")
public class Pay implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String month;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	private  Double pay1;
	
	private Double pay2;

	private Double pay3;
	
	private Double pay4;
	
	private Double pay5;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getPay1() {
		return pay1;
	}

	public void setPay1(Double pay1) {
		this.pay1 = pay1;
	}

	public Double getPay2() {
		return pay2;
	}

	public void setPay2(Double pay2) {
		this.pay2 = pay2;
	}

	public Double getPay3() {
		return pay3;
	}

	public void setPay3(Double pay3) {
		this.pay3 = pay3;
	}

	public Double getPay4() {
		return pay4;
	}

	public void setPay4(Double pay4) {
		this.pay4 = pay4;
	}

	public Double getPay5() {
		return pay5;
	}

	public void setPay5(Double pay5) {
		this.pay5 = pay5;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
}