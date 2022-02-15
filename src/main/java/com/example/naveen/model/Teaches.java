package com.example.naveen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity

public class Teaches {
@Id	
@Column(name="teaches_id", unique = true)
public int id;

public String sub_code;
public int teacher_id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSub_code() {
	return sub_code;
}
public void setSub_code(String sub_code) {
	this.sub_code = sub_code;
}
public int getTeacher_id() {
	return teacher_id;
}
public void setTeacher_id(int teacher_id) {
	this.teacher_id = teacher_id;
}


}
