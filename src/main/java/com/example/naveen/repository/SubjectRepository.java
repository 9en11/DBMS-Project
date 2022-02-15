package com.example.naveen.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.naveen.model.Subject;



@Transactional
@Repository("subjectRepository")
public interface SubjectRepository extends JpaRepository<Subject, String>{
@Query(value="select * from subject", nativeQuery = true)
List<Subject> getallsubject();
@Query(value="select * from subject s where s.class_name=?1", nativeQuery = true)
List<Subject> getsubjectsbyclass(int clas_name);
@Query(value="select * from subject s where s.sub_name=?1", nativeQuery = true)
List<Subject> getsubjectsbysubname(String sub_name);
@Query(value="select * from subject s where s.sub_code=?1", nativeQuery = true)
List<Subject> getsubjectsbysubcode(String sub_code);

@Modifying
@Query(value="insert into subject (sub_code, class_name, sub_name) values (?1,?2,?3)", nativeQuery = true)
void addsubject(String sub_code, int class_name, String sub_name);

@Modifying
@Query(value="delete from subject s where s.sub_code=?1", nativeQuery = true)
void deletesubject(String sub_code);


}
