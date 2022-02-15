package com.example.naveen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.naveen.model.Teacher;
import com.example.naveen.model.Teaches;
import com.example.naveen.repository.TeacherRepository;
import com.example.naveen.repository.TeachesRepository;
@Service
public class TeachesServiceImpl implements TeachesService{

	@Autowired
	TeachesRepository teachesRepository;

	@Override
	public List<Teaches> getTeachesByTeacher(int teacher_id) {
		// TODO Auto-generated method stub
		return teachesRepository.qgetTeachesByTeacher(teacher_id);
	}

	@Override
	public List<Teaches> getTeachesBySubject(String sub_code) {
		// TODO Auto-generated method stub
		return teachesRepository.qgetTeachesBySubject(sub_code);
		
	}

	@Override
	public boolean deleteTeaches(int teacher_id, String sub_code) {
		// TODO Auto-generated method stub
		
		try {
			List<Teaches> teaches = teachesRepository.qgetTeaches(sub_code, teacher_id);
			if(teaches.size() == 0) {
				return false;
			}
			Teaches teaches2 = teaches.get(0);
			teachesRepository.qdeleteTeaches(teaches2.getId());
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public boolean deleteTeachesByTeacher(int teacher_id) {
		try {
			List<Teaches> teaches = teachesRepository.qgetTeachesByTeacher(teacher_id);
			for (int i = 0; i < teaches.size(); i++) {
				int teaches_id = teaches.get(i).getId();
				teachesRepository.qdeleteTeaches(teaches_id);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public boolean deleteTeachesBySubject(String sub_code) {
		try {
			List<Teaches> teaches = teachesRepository.qgetTeachesBySubject(sub_code);
			for (int i = 0; i < teaches.size(); i++) {
				int teaches_id = teaches.get(i).getId();
				teachesRepository.qdeleteTeaches(teaches_id);
			}
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public boolean updateTeaches(Teaches teaches) {
		try {
			teachesRepository.qupdateTeaches(teaches.getTeacher_id(), teaches.getSub_code(), teaches.getId());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean addTeaches(Teaches teaches) {
		try {
			teachesRepository.qaddTeaches(teaches.getSub_code(), teaches.getTeacher_id());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}
	
}
