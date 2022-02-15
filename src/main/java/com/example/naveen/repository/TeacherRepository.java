package com.example.naveen.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.naveen.model.Student;
import com.example.naveen.model.Teacher;
@Transactional
@Repository("teacherRepository")
public interface TeacherRepository extends JpaRepository<Teacher, String>
{   @Modifying
    @Query(value="Insert into teacher (email, name, category, classtof, dob, school_id, bus_no, address_string) values(?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery = true)
	void addTeacher(String email, String name, String category, int classTof, 
			Date dob, int school_id, int bus_no, String address_string);
@Query(value="select * from teacher", nativeQuery = true)
List<Teacher> getAllteachers();

@Query(value="select * from teacher t where t.teacher_id=?1", nativeQuery = true)
List<Teacher>  getTeacherbyid(int id);

@Query(value="select * from teacher t where t.school_id=?1", nativeQuery=true)
List<Teacher> getTeacherbyschool_id(int school_id);

@Query(value="select * from teacher t where t.bus_no=?1", nativeQuery=true)
List<Teacher> getTeacherbybus_no(int bus_no);


@Query(value="SELECT * FROM teacher t where t.email=?1" , nativeQuery=true)
Teacher findTeacherbyemail(String email);
	

@Modifying
@Query(value="delete from teacher t where t.teacher_id=?1", nativeQuery = true)
void deleteTeacherbyid(int id);
	
	@Modifying
	@Query(value="update teacher t set name=?1, category=?2, classtof=?3, dob=?4, school_id=?5, bus_no=?6 , address_string=?7 where t.teacher_id=?8", nativeQuery = true)
	void updateTeacherbyid(String name, String category, int classtof, Date dob, int school_id, int bus_no, String address_string, int id);
	
}
