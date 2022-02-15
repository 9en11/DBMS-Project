package com.example.naveen.service;

import java.util.List;

import com.example.naveen.model.Teaches;

public interface TeachesService {
	public List<Teaches> getTeachesByTeacher(int teacher_id);
	public List<Teaches> getTeachesBySubject(String sub_code);
	public boolean deleteTeaches(int teacher_id, String sub_code);
	public boolean deleteTeachesByTeacher(int teacher_id);
	public boolean deleteTeachesBySubject(String sub_code);
	public boolean updateTeaches(Teaches teaches);
	public boolean addTeaches(Teaches teaches);
}
