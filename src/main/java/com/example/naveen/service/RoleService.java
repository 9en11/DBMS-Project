package com.example.naveen.service;

import java.util.List;

import com.example.naveen.model.Role;

public interface RoleService {
   public Role findrolebyuser(String user_id);
   
   List<Role> getusersbyrole(String user_role);
   
   public boolean adduser(Role role);
   
   public boolean  deleteuser(String user_id);
   List<Role> getallusers();
	
}
   
   
   
   

