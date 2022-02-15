package com.example.naveen.model;
import java.sql.Date;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.example.naveen.Controller.studentcontroller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="student")

public     class Student{
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO, generator = "native")
    private int adm_no;
	@Size(max=30)
	private String first_name;
	@Size(max=30)
	private String middle_name;
	@Size(max=30)
	private String last_name;
	
	
	private int  class_id;
	
	private int roll_no;

	@Size(max=30)
	private String contact_no;
	private int  school_id;
	@Size(max=30)
	private String sex;
	private int  bus_no;
	@Column(unique = true)
	private String email;

	private String address;

	@Column(name="dob")
	private Date dob;
	
   
public Student() {
	
}


	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}





	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAdm_no() {
		return adm_no;
	}

	public void setAdm_no(int adm_no) {
		this.adm_no = adm_no;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public int getRoll_no(){
		return roll_no;
	}

	public void setRoll_no(int roll_no){
		this.roll_no=roll_no;
	}

	public String getContact_no(){
		return contact_no;
	}

	public void setContact_no(String contact_no){
		this.contact_no=contact_no;
	}



	public String getSex(){
		return sex;
	}

	public void setSex(String sex){
		this.sex=sex;
	}

	public int getBus_no(){
		return bus_no;
	}

	public void setBus_no(int Bus_no){
		this.bus_no=Bus_no;
	}

	public int getSchool_id(){
		return school_id;
	}

	public void setSchool_id(int school_id){
		this.school_id=school_id;
	}
}