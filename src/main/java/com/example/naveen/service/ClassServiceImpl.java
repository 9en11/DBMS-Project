package com.example.naveen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naveen.model.Class;
import com.example.naveen.repository.ClassRepository;

@Service
public class ClassServiceImpl implements ClassService{
@Autowired
ClassRepository classRepository;

	@Override
	public Class getclassbyclass_id(int class_id) {
		// TODO Auto-generated method stub
		return classRepository.getclassbyclass_id(class_id).get(0) ;
	}

}
