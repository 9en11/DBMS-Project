package com.example.naveen.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.naveen.model.Role;
@Transactional
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository <Role, String>{
@Query(value="SELECT * FROM role r where r.user_id=?1", nativeQuery=true)	
List<Role> getRolebyuser_id(String user_id);


@Modifying
@Query(value="INSERT INTO role (user_id, user_password, user_role) values(?1, ?2, ?3)", nativeQuery=true)
void addRole(String user_id, String user_password, String user_role);


@Modifying
@Query(value="delete from role r where r.user_id=?1", nativeQuery = true)
void deleteuser(String user_id);

@Query(value="select * from role r where r.user_role=?1", nativeQuery = true)
List<Role> getusersbyroles(String user_role);
@Query(value="select * from role ", nativeQuery = true)
List<Role> getallusers();


}
