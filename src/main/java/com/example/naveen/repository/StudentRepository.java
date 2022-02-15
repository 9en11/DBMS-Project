package com.example.naveen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.naveen.model.Student;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
@Transactional
@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query(value="select * from student", nativeQuery = true)
	List<Student> getAllStudents();
	
	@Query(value="select * from student s where s.adm_no=?1", nativeQuery = true)
	List<Student>  getStudentbyadm_no(int adm_no);
	
	@Query(value="select * from student s where s.class_id=?1 and s.school_id=?2", nativeQuery = true)
	List<Student> getStudentbyclass_id(int class_id, int school_id);
	
	@Query(value="select * from student s where s.school_id=?1", nativeQuery=true)
	List<Student> getStudentbyschool_id(int school_id);
	
	@Query(value="SELECT * from student s where s.roll_no=?1 and s.class_id=?2 and s.school_id=?3", nativeQuery = true)
	List<Student> getStudentbyroll_no(int roll_no, int class_id, int school_d);
	@Modifying
	@Query(value="INSERT INTO student (first_name, middle_name, last_name, class_id, roll_no, contact_no, school_id, sex, Bus_no, email, address, dob) values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12)", nativeQuery = true)
	void addStudent(String first_name, String middle_name, String last_name, int class_id,int roll_no, String contact_no, int school_id, String sex, Integer Bus_id,String email, String address, Date dobDate);
	
	@Query(value="SELECT * FROM student s where s.email=?1" , nativeQuery=true)
	Student findStudenbyemail(String email);
	
	@Modifying
	@Query(value="delete from student s where s.adm_no=?1", nativeQuery = true)
	void deleteStudentbyadm_no(int adm_no);
	@Modifying
	@Query(value = "update student s set first_name=?1, middle_name=?2, last_name=?3, class_id=?4, roll_no=?5, contact_no=?6, school_id=?7, sex=?8, Bus_no=?9, address=?10 , dob=?11 where s.adm_no=?12", nativeQuery = true)
	void updateStudent(String first_name, String middle_name, String last_name, int class_id,int roll_no, String contact_no, int school_id, String sex, int Bus_id, String address, Date dob, int adm_no);
	
	@Query(value="SELECT * FROM student s where s.bus_no=?1" , nativeQuery=true)
	List<Student> findStudentbybus_no(int bus_no);
	
	

}
