package com.example.naveen.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naveen.model.Student;
import com.example.naveen.repository.StudentRepository;


@Service("studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

	@Override
	public List<Student> getallstudents() {
		// TODO Auto-generated method stub
		
		List<Student> students=studentRepository.getAllStudents();
		return students;
	}

	@Override
	public Student getstudentbyadm_no(int adm_no) {
		// TODO Auto-generated method stub
		List<Student> student =studentRepository.getStudentbyadm_no(adm_no);
		if(student.size()!=0)
			 
		return student.get(0);
		else {
		 Student student2 = null;
		 return student2;
		}
	}

	@Override
	public List<Student> getstudentbyclass_id(int class_id, int school_id) {
		// TODO Auto-generated method stub
		
		List<Student> students=studentRepository.getStudentbyclass_id(class_id, school_id);
		return students;
	}

	@Override
	public List<Student> getstudentbyschool_id(int school_id) {
		// TODO Auto-generated method stub
		List<Student> students=studentRepository.getStudentbyschool_id(school_id);
		return students;
	}

	@Override
	public List<Student> getstudentbyroll_no(int roll_no, int class_id, int school_id) {
		// TODO Auto-generated method stub
		List<Student> students=studentRepository.getStudentbyroll_no(roll_no, class_id, school_id);
		return students;
	}

	@Override
	public boolean addstudent(Student student) {
		// TODO Auto-generated method stub
		
		try {		
			studentRepository.addStudent(student.getFirst_name(), student.getMiddle_name(), student.getLast_name(), student.getClass_id(), student.getRoll_no(), student.getContact_no(), student.getSchool_id(), student.getSex(), student.getBus_no(), student.getEmail(),  student.getAddress(), student.getDob());
			System.out.println("Student added successfully");
			return true;
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
			
		}
	
	}

	@Override
	public boolean deletestudent(int adm_no) {
		// TODO Auto-generated method stub
		
		try {
			studentRepository.deleteStudentbyadm_no(adm_no);
			System.out.println("Deletion of student succesfully");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Student findstudentbyemail(String email) {
		// TODO Auto-generated method stub
		
		Student student=studentRepository.findStudenbyemail(email);
		
		return student;
	}

	@Override
	public boolean updatestudent(Student student, int adm_no) {
		// TODO Auto-generated method stub
		try {
			studentRepository.updateStudent(student.getFirst_name(), student.getMiddle_name(), student.getLast_name(), student.getClass_id(), student.getRoll_no(), student.getContact_no(), student.getSchool_id(), student.getSex(), student.getBus_no(), student.getAddress(),student.getDob() , adm_no);
			System.out.println("Student updated successfully");
			return true;
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public List<Student> getstudentbybus_no(int bus_no) {
		// TODO Auto-generated method stub
		List<Student> list=studentRepository.findStudentbybus_no(bus_no);
		return list;
	
	}


 

}
