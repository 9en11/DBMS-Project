package com.example.naveen.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.naveen.model.Class;
@Transactional
@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {
	
	@Query(value="select * from class where class.class_id=?1", nativeQuery = true)
	List<Class> getclassbyclass_id(int class_id);
	
	
	

}
