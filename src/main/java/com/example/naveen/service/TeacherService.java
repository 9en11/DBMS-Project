package com.example.naveen.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.naveen.model.Teacher;
@Repository("teacherRepository")
public interface TeacherService {
public boolean addteacher(Teacher teacher);

public boolean  updateteacher(Teacher teacher, int id);

public boolean  deleteteacher(int id); 


public Teacher getteacherbyid(int id);

public Teacher getteacherbyemail(String email);

List<Teacher> getallteachers();
List<Teacher> getteacherbyschool_id(int school_id);
List<Teacher> getteacherbybus_no(int bus_no);




}
