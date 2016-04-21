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
 *调任
 */
@Entity
@Table(name = "t_leave")
public class Leave implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	private String dept;
	
	private String leavel;
    
	private String todept;
	
	private String tolevel;
	
	private String reason;
	
	private String sign;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
	private Date signDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getLeavel() {
		return leavel;
	}

	public void setLeavel(String leavel) {
		this.leavel = leavel;
	}

	public String getTodept() {
		return todept;
	}

	public void setTodept(String todept) {
		this.todept = todept;
	}

	public String getTolevel() {
		return tolevel;
	}

	public void setTolevel(String tolevel) {
		this.tolevel = tolevel;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
}