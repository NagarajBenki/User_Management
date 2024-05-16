package com.nagaraj.user.entity;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phno")
	private Long phno;
	
	@Column(name = "dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	@Column(name = "ssn")
	private Long ssn;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "active_sw")
	private String active_sw;

	@CreationTimestamp
	@Column(name = "create_date",updatable = false)
	private LocalDate createDate;
	
	@UpdateTimestamp
	@Column(name = "update_date", insertable = false)
	private LocalDate updateDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getActive_sw() {
		return active_sw;
	}

	public void setActive_sw(String active_sw) {
		this.active_sw = active_sw;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "UserAccounts [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", phno=" + phno
				+ ", dob=" + dob + ", ssn=" + ssn + ", gender=" + gender + ", active_sw=" + active_sw + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}
	
	

}
