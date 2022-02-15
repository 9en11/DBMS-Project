package com.example.naveen.service;

import java.awt.image.RescaleOp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naveen.model.Teacher;
import com.example.naveen.repository.TeacherRepository;
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{
   @Autowired
   TeacherRepository teacherRepository;
	@Override
	public boolean addteacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			teacherRepository.addTeacher(teacher.getEmail(), teacher.getName(), teacher.getCategory(), teacher.getClass_name(), teacher.getDob(), teacher.getSchool_id(), teacher.getBus_no(), teacher.getAddress_string());
			System.out.println("Tecaher added succesfully");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	
	}
	@Override
	public boolean updateteacher(Teacher teacher, int id) {
		// TODO Auto-generated method stub
		try {
		teacherRepository.updateTeacherbyid(teacher.getName(),	 teacher.getCategory(), teacher.getClass_name(), teacher.getDob(), teacher.getSchool_id(), teacher.getBus_no(), teacher.getAddress_string(),teacher.getId());
		System.out.println("Teacher updated succesfully");
		return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
			
		}
		
	}
	@Override
	public boolean deleteteacher(int id) {
		// TODO Auto-generated method stub
		try {
			teacherRepository.deleteTeacherbyid(id);
			System.out.println("Teacher deleted successfully");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			
			return false;
		}
		
	}
	@Override
	public Teacher getteacherbyid(int id) {
		// TODO Auto-generated method stub
		Teacher teacher=teacherRepository.getTeacherbyid(id).get(0);
	
		return teacher;
	}
	@Override
	public Teacher getteacherbyemail(String email) {
		// TODO Auto-generated method stub
		Teacher teacher= teacherRepository.findTeacherbyemail(email);
		
		return teacher;
	}
	
	@Override
	public List<Teacher> getallteachers() {
		// TODO Auto-generated method stub
		List<Teacher> teachers =teacherRepository.getAllteachers();
		return teachers;
	}
	@Override
	public List<Teacher> getteacherbyschool_id(int school_id) {
		// TODO Auto-generated method stub
		List<Teacher> teachers=teacherRepository.getTeacherbyschool_id(school_id);
		return teachers;
	
	}
	@Override
	public List<Teacher> getteacherbybus_no(int bus_no) {
		// TODO Auto-generated method stub
		List<Teacher> list=teacherRepository.getTeacherbybus_no(bus_no);
		
		return list;
	}

}
