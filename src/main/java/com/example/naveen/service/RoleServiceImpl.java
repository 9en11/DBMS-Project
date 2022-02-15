package com.example.naveen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.naveen.model.Role;
import com.example.naveen.repository.RoleRepository;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public Role findrolebyuser(String user_id) {
		// TODO Auto-generated method stub
		List<Role> roles=roleRepository.getRolebyuser_id(user_id);
		if(roles.size()==0)
			  return null;
		else
		{
			Role role=roles.get(0);
			
		return role;
		}
	}


	@Override
	public boolean adduser(Role role) {
		// TODO Auto-generated method stub
		
		try {
			BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
			String passString=role.getUser_password();
			
			roleRepository.addRole(role.getUser_id(), bCryptPasswordEncoder.encode(passString), role.getUser_role());
			System.out.println("User added successfully");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		
	}


	@Override
	public boolean deleteuser(String user_id) {
		// TODO Auto-generated method stub
		try {
			roleRepository.deleteuser(user_id);
			System.out.println("User deleted successfully");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
			
		}
	
	}


	@Override
	public List<Role> getusersbyrole(String user_role) {
		// TODO Auto-generated method stub
		List<Role> usersList=roleRepository.getusersbyroles(user_role);
		
		return usersList;
	}


	@Override
	public List<Role> getallusers() {
		// TODO Auto-generated method stub
		List<Role> userList= roleRepository.getallusers();
		
		return userList;
	}

}
