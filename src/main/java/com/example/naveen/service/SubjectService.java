package com.example.naveen.service;

import java.util.List;

import com.example.naveen.model.Subject;

public interface SubjectService {

	List<Subject> getallsubjects();
	List<Subject> getsubjectbyclass_name(int class_name);
	List<Subject> getsubjectbysub_name(String sub_name);
	Subject getsubjectbysub_code(String sub_code);
	
	
}
