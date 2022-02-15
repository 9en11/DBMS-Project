package com.example.naveen.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.example.naveen.model.Class;
import com.example.naveen.model.Admin;
import com.example.naveen.model.Role;
import com.example.naveen.model.Student;
import com.example.naveen.model.Subject;
import com.example.naveen.model.Teacher;
import com.example.naveen.model.Teaches;
import com.example.naveen.repository.StudentRepository;
import com.example.naveen.repository.TeacherRepository;
import com.example.naveen.service.ClassService;
import com.example.naveen.service.RoleService;
import com.example.naveen.service.StudentService;
import com.example.naveen.service.SubjectService;
import com.example.naveen.service.TeacherService;
import com.example.naveen.service.TeachesService;



@Controller

public class teachercontroller {

    @Autowired
    RoleService roleService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
 @Autowired 
 TeachesService teachesService;
 @Autowired
 SubjectService subjectService;
 
 @Autowired
 ClassService classService;
	@RequestMapping("/teacher")
	  public String teacher(Model model, Principal principal)
	  { com.example.naveen.model.Role role=roleService.findrolebyuser(principal.getName());
		String user_id=role.getUser_id();
		Teacher teacher =teacherService.getteacherbyemail(user_id);
		model.addAttribute("teacherfname", teacher.getName());
		
		
			return "teacher";
			
	  }
	@RequestMapping(value = "/teacher/viewprofile")
	public String welcome2(Model model, Principal principal) {
		
	        Teacher teacher=teacherService.getteacherbyemail((principal.getName()));
			model.addAttribute("teacher",teacher);
			model.addAttribute("topic","Teacher Profile");
			
			
			return "viewteacherprofile";
		
	}
	
	@RequestMapping(value="/teacher/viewyoursubjects")
	public String tsubjects(Model model, Principal principal)
	{
		 Teacher teacher=teacherService.getteacherbyemail(principal.getName());
		 int teacher_id=teacher.getId();
		List<Teaches> teaches= teachesService.getTeachesByTeacher(teacher_id);
		List<Subject> list=new ArrayList<Subject>();
		for (int i = 0; i < teaches.size(); i++) {
			String sub_code = teaches.get(i).getSub_code();
			list.add(subjectService.getsubjectbysub_code(sub_code));
			
		}
		 model.addAttribute("subjects", list);
		 return "viewteachersubjects"; 
	}
	
    
	@RequestMapping(value="/teacher/viewyourclass")
	public String classdetails(Model model, Principal principal)
	{
		 Teacher teacher=teacherService.getteacherbyemail(principal.getName());
		 int class_id=teacher.getClass_name();
		Class class1=classService.getclassbyclass_id(class_id);
		model.addAttribute("class", class1);
		model.addAttribute("teacher", teacher);
		return "viewclassbyteacher";
	}
	@RequestMapping(value="/teacher/viewstudents")
	public String viewstudentsofclass(Model model, Principal principal)
	{
		 Teacher teacher=teacherService.getteacherbyemail(principal.getName());
		 int class_id=teacher.getClass_name();
		 int school_id=teacher.getSchool_id();
		 List<Student> students=studentService.getstudentbyclass_id(class_id, school_id);
		 model.addAttribute("students", students);
		 return "viewstudentsbyteacherjsp";
	
	}
	
	
}
