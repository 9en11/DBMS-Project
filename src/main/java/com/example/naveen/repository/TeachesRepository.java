package com.example.naveen.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.naveen.model.Teaches;

@Repository("teachesRepository")
@Transactional
public interface TeachesRepository extends JpaRepository<Teaches, Integer>{
	@Query(value = "SELECT * FROM teaches WHERE teacher_id = ?1", nativeQuery = true)
	List<Teaches> qgetTeachesByTeacher(int teacher_id);
	
	@Query(value = "SELECT * FROM teaches WHERE sub_code = ?1", nativeQuery = true)
	List<Teaches> qgetTeachesBySubject(String sub_code);
	
	@Query(value = "SELECT * FROM teaches WHERE sub_code = ?1 and teacher_id = ?2", nativeQuery = true)
	List<Teaches> qgetTeaches(String sub_code, int teacher_id);
	
	@Modifying
	@Query(value = "DELETE FROM teaches WHERE teaches_id = ?1", nativeQuery = true)
	void qdeleteTeaches(int teaches_id);
	
	@Modifying
	@Query(value = "INSERT INTO teaches(sub_code, teacher_id) values(?1,?2)", nativeQuery = true)
	void qaddTeaches(String sub_code, int teacher_id);
	
	@Modifying
	@Query(value = "UPDATE teaches SET teacher_id = ?1, sub_code = ?2 WHERE teaches_id = ?3", nativeQuery = true)
	void qupdateTeaches(int teacher_id, String subject_code, int teaches_id);
	
	
}
