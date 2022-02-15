package com.example.naveen.model;
import javax.persistence.Column;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
public class Class {
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO, generator = "native")
	public int class_id;
	public int class_name;
	public int classtid;
	public int school_id;
	
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public int getClasstid() {
		return classtid;
	}
	public void setClasstid(int classtid) {
		this.classtid = classtid;
	}
	public int getClass_name() {
		return class_name;
	}
	public void setClass_name(int class_name) {
		this.class_name = class_name;
	}
	public int getSchool_id() {
		return school_id;
	}
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}
	
	

}
