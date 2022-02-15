package com.example.naveen;

import javax.persistence.criteria.Root;

import com.example.naveen.model.Role;
import com.example.naveen.repository.RoleRepository;
import com.example.naveen.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component    
public class Startup implements CommandLineRunner {
    @Autowired
    RoleService roleService;

    @Override
    public void run(String...args) throws Exception {
        Role role = new Role();
        role.setUser_id("naveenmall");
        role.setUser_password("naveen@12345");
        role.setUser_role(Role.ROLE_ADMIN);
        roleService.adduser(role);
    }
}
