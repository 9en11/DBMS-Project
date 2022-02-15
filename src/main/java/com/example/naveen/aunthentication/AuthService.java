package com.example.naveen.aunthentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.naveen.model.Role;
import com.example.naveen.repository.RoleRepository;
import com.example.naveen.service.RoleService;

@Service("authService")
public class AuthService implements UserDetailsService {

	@Autowired
  private	RoleService roleService;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Role role=roleService.findrolebyuser(username);
		if(role==null)
		{
			throw new UsernameNotFoundException("Sorry" + username + "Wrong Credential!!");
		}
		
		String userroleString=role.getUser_role();
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		
GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userroleString);
		
		grantList.add(authority);
		UserDetails userDetails = (UserDetails) new User(role.getUser_id(), role.getUser_password()
		, true, true, true, true, grantList);

 return userDetails;
		
		
	}
	
	
	

}
