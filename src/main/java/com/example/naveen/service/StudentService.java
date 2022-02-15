package com.example.naveen.service;

import com.example.naveen.model.Student;

import java.util.List;

import javax.servlet.jsp.PageContext;;

public interface StudentService {
	
List<Student> getallstudents();

public Student getstudentbyadm_no(int adm_no);

public List<Student> getstudentbyclass_id(int class_id, int school_id);

public List<Student> getstudentbyschool_id(int school_id);
public List<Student> getstudentbybus_no(int bus_no);

public List<Student> getstudentbyroll_no(int roll_no, int class_id, int school_id);

public boolean addstudent(Student student);

public boolean deletestudent(int adm_no);

public boolean updatestudent(Student student, int adm_no) ;
	




	
public Student findstudentbyemail(String email);











  
}
