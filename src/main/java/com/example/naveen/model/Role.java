package com.example.naveen.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="role")
public class Role {
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String ROLE_TEACHER = "TEACHER";
//	public static final String ROLE_INCHARGE = "INCHARGE";
//	public static final String ROLE_CLS_TEACHER = "CLS_TEACHER";
//	public static final String ROLE_PEON = "PEON";
	public static final String ROLE_STUDENT = "STUDENT";
	
	 @Id
	 @NotEmpty(message = "required")
	public String user_id;
	 
	public String user_password;
	@NotEmpty(message = "Required")
	public String user_role;
	public String getUser_id() {
		return user_id;
	}
	
	
	public Role()
	{
		
	}
	
	
	public Role(String user_id, String user_password, String user_role) {
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_role = user_role;
	}





	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	
	
	
}
