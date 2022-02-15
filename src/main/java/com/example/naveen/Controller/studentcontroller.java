package com.example.naveen.Controller;

import java.security.Principal;
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

import com.example.naveen.model.Admin;
import com.example.naveen.model.Fee;
import com.example.naveen.model.Role;
import com.example.naveen.model.Student;
import com.example.naveen.model.Subject;
import com.example.naveen.model.Teacher;
import com.example.naveen.repository.FeeRepository;
import com.example.naveen.repository.StudentRepository;
import com.example.naveen.repository.TeacherRepository;
import com.example.naveen.service.FeeService;
import com.example.naveen.service.RoleService;
import com.example.naveen.service.StudentService;
import com.example.naveen.service.SubjectService;
import com.example.naveen.service.TeacherService;



@Controller
public class studentcontroller {
    @Autowired
    RoleService roleService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    FeeService feeService;
    @Autowired
    SubjectService subjectService;
    
	@RequestMapping("/student")
	  public String student( Model model, Principal principal)
	  { 	com.example.naveen.model.Role role=roleService.findrolebyuser(principal.getName());
	    		String user_id=role.getUser_id();
			Student student=studentService.findstudentbyemail(user_id);
	    model.addAttribute("studentfname", student.getFirst_name());
	    model.addAttribute("studentsname", student.getLast_name());
			return "student";
			
	  }
	@RequestMapping(value = "/student/viewprofile")
	public String welcome2(Model model, Principal principal) {
		
	        Student student=studentService.findstudentbyemail((principal.getName()));
			model.addAttribute("student",student);
			model.addAttribute("topic","Student Profile");
			
			
			return "viewstudentprofile";
		
	}
    
	@RequestMapping(value="/student/feestatus")
	public String feestatus(Model model, Principal principal)
	{
		 Student student=studentService.findstudentbyemail((principal.getName()));
		 int adm_no=student.getAdm_no();
		 List<Fee> list=feeService.getfeedetails(adm_no);
		 model.addAttribute("list", list);
		 return "feestatus"; 
	}
	@RequestMapping(value="/student/viewsubjects")
	public String subjects(Model model, Principal principal)
	{
		 Student student=studentService.findstudentbyemail((principal.getName()));
		 int class_name=student.getClass_id();
		List<Subject> list=subjectService.getsubjectbyclass_name(class_name); 
		 model.addAttribute("subjects", list);
		 return "viewstudentsubjects"; 
	}
	
    
}
