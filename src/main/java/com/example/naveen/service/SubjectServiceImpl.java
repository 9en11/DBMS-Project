package com.example.naveen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naveen.model.Subject;
import com.example.naveen.repository.SubjectRepository;
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {
 @Autowired
 SubjectRepository subjectRepository;
	@Override
	public List<Subject> getallsubjects() {
		// TODO Auto-generated method stub
		List<Subject> s1=subjectRepository.getallsubject();
		
		return s1;
	}

	@Override
	public List<Subject> getsubjectbyclass_name(int class_name) {
		// TODO Auto-generated method stub
	List<Subject> s1=subjectRepository.getsubjectsbyclass(class_name);
		
		return s1;
	}

	@Override
	public List<Subject> getsubjectbysub_name(String sub_name) {
		// TODO Auto-generated method stub
	List<Subject> s1=subjectRepository.getsubjectsbysubname(sub_name);
		
		return s1;

	}

	@Override
	public Subject getsubjectbysub_code(String sub_code) {
		// TODO Auto-generated method stub
	List<Subject> s1=subjectRepository.getsubjectsbysubcode(sub_code);
		
		return s1.get(0);
	}

}
