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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.naveen.model.Admin;
import com.example.naveen.model.Bus;
import com.example.naveen.model.Fee;
import com.example.naveen.model.Role;
import com.example.naveen.model.School;
import com.example.naveen.model.Student;
import com.example.naveen.model.Subject;
import com.example.naveen.model.Teacher;
import com.example.naveen.model.Teaches;
import com.example.naveen.repository.StudentRepository;
import com.example.naveen.repository.TeacherRepository;
import com.example.naveen.repository.TeachesRepository;
import com.example.naveen.service.BusService;
import com.example.naveen.service.FeeService;
import com.example.naveen.service.RoleService;
import com.example.naveen.service.StudentService;
import com.example.naveen.service.SubjectService;
import com.example.naveen.service.TeacherService;
import com.example.naveen.service.TeachesService;





@Controller
public class homeController {
    @Autowired
    RoleService roleService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired 
    BusService busService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    FeeService feeService;
    @Autowired
    TeachesService teachesService;
	@RequestMapping(path="/home")
	public String home()
	{
		return "home";
	}
	@RequestMapping(path="/")
	public String homeb()
	{ BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("naveen@123"));
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";
	}
	
	@RequestMapping(value = "/login1")
	public String welcome(Model model, Principal principal) {
		
		if(principal != null)
		{
			//System.out.println("abcd");
		 com.example.naveen.model.Role role=roleService.findrolebyuser(principal.getName());
			String role_type=role.getUser_role();

			if(role_type.equals("ADMIN"))return "redirect:/admin";
			else if(role_type.equals("STUDENT"))return "redirect:/student";
			else if(role_type.equals("TEACHER"))return "redirect:/teacher";
			
			
		//	System.out.println(role_type);
		
			
		}
		//System.out.println("bhdbhdv");
		return "redirect:/login";
	}
	
	@RequestMapping("/admin")
	public String admin()
	{
		return "admin";
	}

	@RequestMapping("/about")
	public String about()
	{
		return "home";
	}

	@RequestMapping("/contact")
	public String contact()
	{
		return "home";
	}

	@RequestMapping(path="/403")
	public String error()
	{
		return "/403";
	}
	@RequestMapping("/logout")
	public String  logout(ModelMap model) {
		model.addAttribute("message",
				"You have successfully logged off from application !");
		return "logout";
	}
	
	
	@RequestMapping(value="/admin/register", method = RequestMethod.GET)
	public String register(Model model)
	{

		Map< String, String > types = new HashMap<String, String>();
        types.put("TEACHER", "Teacher");
        types.put("STUDENT", "Student");
        types.put("ADMIN", "Admin");
       
         
        model.addAttribute("typesList", types);
		
		Role user = new Role();
		model.addAttribute("role", user);

		return "register";
	
	}
	
	@RequestMapping(value="/admin/register",method=RequestMethod.POST)
	public String registerProcess(@Valid @ModelAttribute("role") Role role,BindingResult result,Model model) {
		if(result.hasErrors()) {
			Map< String, String > types = new HashMap<String, String>();
	        types.put("TEACHER", "Teacher");
	        types.put("STUDENT", "Student");
	        types.put("ADMIN", "Admin");
	       
	         
	        model.addAttribute("typesList", types);
			return "register";
		}
		else {
			String s=new String("");
			if(roleService.findrolebyuser(role.getUser_id())!=null) {
				model.addAttribute("error", "Username already exists!");
				Map< String, String > types = new HashMap<String, String>();
		        types.put("TEACHER", "Teacher");
		        types.put("STUDENT", "Student");
		        types.put("ADMIN", "Admin");
		       
		         
		        model.addAttribute("typesList", types);
				return "register";
			}
			
			else if(role.getUser_role().equals(s))
			{ 	
				model.addAttribute("error", "Please Select user role");
				Map< String, String > types = new HashMap<String, String>();
		        types.put("TEACHER", "Teacher");
		        types.put("STUDENT", "Student");
		        types.put("ADMIN", "Admin");
		       
		         
		        model.addAttribute("typesList", types);
				return "register";
			}
			 roleService.adduser(role);
			 String studentString= new String("STUDENT");
			 String teacherString=new String("TEACHER");
			 
			// System.out.println(role.getUser_role());
			 if(role.getUser_role().equals(studentString)) {
				 Student student=new Student();
				 	student.setEmail(role.getUser_id());
				
			
			 
			  studentService.addstudent(student);
			  Student student2=studentService.findstudentbyemail(student.getEmail());
			  int adm_no=student2.getAdm_no();
			  System.out.println(adm_no);
			  return "redirect:/admin/editStudent/"+adm_no;
			 }
			 else if(role.getUser_role().equals(teacherString))
			 {  //System.out.println("nnfjfvb");
				 Teacher teacher= new Teacher();
			  	teacher.setEmail(role.getUser_id());
			  
				System.out.println(teacher.getEmail());			  
				
				teacherService.addteacher(teacher);
			  	Teacher teacher2 =teacherService.getteacherbyemail(teacher.getEmail());
			  	System.out.println(teacher2.getId());
			  	int id=teacher2.getId();
			  	return "redirect:/admin/editteacher/"+id;
				 
				 
			 }
			
		
			 
			 
			return "redirect:/admin";
		}
	}
	
	
	@RequestMapping(value="/admin/viewusers", method = RequestMethod.GET)
	public String viewusers(Model m)
	{
		List<Role> list=roleService.getallusers();
		m.addAttribute("users", list);
		return "viewusers";
	}
	

	@RequestMapping(value="/admin/viewusers", method = RequestMethod.POST)
	public String viewusersp(@Valid @ModelAttribute("userData") Role role , BindingResult result ,Model m)
	{ if(result.hasErrors())
	   {System.out.println("Wrong");
	   
		return "viewusers";
	   	}
	 	System.out.println(role.getUser_role());
	 	if(role.getUser_role().equals("0"))
	 		return "viewusers";
		List<Role> list=roleService.getusersbyrole(role.getUser_role());
		m.addAttribute("users", list);
		return "viewusers";
	}
	
	@RequestMapping(value="/admin/viewteachers", method = RequestMethod.GET)    
    public String viewteachers(Model m){    
        List<Teacher> list=teacherService.getallteachers();  
        m.addAttribute("teachers",list);  
        return "viewteachers";    
    }   
	
	
	
	@RequestMapping(value="/admin/viewstudents", method = RequestMethod.GET)    
    public String views(Model m){    
        List<Student> list=studentService.getallstudents();  
        m.addAttribute("students",list);  
        return "viewstudents";    
    }   
	
	@RequestMapping(value="/admin/viewsubjects", method = RequestMethod.GET)    
    public String viewsub(Model m){    
        List<Subject> list= subjectService.getallsubjects();
        m.addAttribute("subjects",list);  
        return "viewsubjects";    
    }   
	
	@RequestMapping(value="/admin/viewsubjects", method = RequestMethod.POST)
	public String viewsubs(@Valid @ModelAttribute("subjectData") Subject subject, BindingResult result, Model model)
	{ 
		if(result.hasErrors())
		   {//System.out.println("Wrong");
		   
			 List<Subject> list= subjectService.getallsubjects();
		        model.addAttribute("subjects",list);  
		        return "viewsubjects";   
		   	}
		else {
			List<Subject> list=subjectService.getsubjectbyclass_name(subject.getClass_name());
			model.addAttribute("subjects", list);
			return "viewsubjects";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/admin/viewteachers", method = RequestMethod.POST)
	public String viewteacher(@Valid @ModelAttribute("teacherData") Teacher teacher, BindingResult result, Model model)
	{  if(result.hasErrors())
	   {System.out.println("Wrong");
	   
		return "viewteachers";
	   	}
	 if(teacher.getSchool_id()==0)
	 {
		 List<Teacher> teachers=teacherService.getallteachers();
		 model.addAttribute("teachers", teachers);
		 return "viewteachers";
	 }
	 else {
		 List<Teacher> teachers=teacherService.getteacherbyschool_id(teacher.getSchool_id());
		 model.addAttribute("teachers", teachers);
		 return "viewteachers";
	}
	
	
	
	}
	
	
	
	
	
	
	@RequestMapping(value="/admin/viewstudents", method = RequestMethod.POST)
	public String viewstudents(@Valid @ModelAttribute("studentData") Student student, BindingResult result, Model model)
	{  if(result.hasErrors())
	   {System.out.println("Wrong");
	   
		return "viewstudents";
	   	}

	
	// System.out.println(student.getSchool_id());
		 if(student.getSchool_id()==0 && student.getClass_id()==0)
		 {
		  List<Student> students=studentService.getallstudents();
		  model.addAttribute("students", students);
		  return "viewstudents";
	
		 }
		 else if (student.getClass_id()==0 && student.getSchool_id()!=0) {
			 List<Student> students=studentService.getstudentbyschool_id(student.getSchool_id());
			 model.addAttribute("students", students);
			 return "viewstudents";
			
		} else {
				List<Student> students=studentService.getstudentbyclass_id(student.getClass_id(), student.getSchool_id());
				 model.addAttribute("students", students);
				 return "viewstudents";
				
		}
		
	}
	
	
	
	
	@RequestMapping(value="admin/deleteuser/{user_id}", method = RequestMethod.GET)
	public String deleteuser(@PathVariable String user_id) {
		
		Role user_roleString=roleService.findrolebyuser(user_id);
		roleService.deleteuser(user_id);
		if(user_roleString.getUser_role().equals("STUDENT"))
		{
			Student student= studentService.findstudentbyemail(user_roleString.getUser_id());
			studentService.deletestudent(student.getAdm_no());
			return "redirect:/admin/viewusers";
		}
		else {
			Teacher teacher =teacherService.getteacherbyemail(user_roleString.getUser_id());
			System.out.println(teacher.getId());
			teacherService.deleteteacher(teacher.getId());
			return "redirect:/admin/viewusers";
		}
		
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/admin/deleteteacher/{id}",method = RequestMethod.GET)  
    public ModelAndView deleteTeacher(@PathVariable int id){  
		
		Teacher teacher =teacherService.getteacherbyid(id);
		teacherService.deleteteacher(id);
		roleService.deleteuser(teacher.getEmail());
        return new ModelAndView("redirect:/admin/viewteachers");  
    }
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/admin/deleteStudent/{adm_no}",method = RequestMethod.GET)  
    public ModelAndView deleteStudent(@PathVariable int adm_no){  
		
		Student student =studentService.getstudentbyadm_no(adm_no);
		studentService.deletestudent(adm_no);
		roleService.deleteuser(student.getEmail());
        return new ModelAndView("redirect:/admin/viewstudents");  
    }
	
	
	
	
	
	@RequestMapping(value="/admin/editteacher/{id}",method=RequestMethod.GET)
	public String editTeacherProfile(Model model, @PathVariable int id) {
	
		Teacher teacher =teacherService.getteacherbyid(id);
		model.addAttribute("teacher", teacher);
		return "editteacherbyadmin";
	
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/admin/editStudent/{adm_no}",method=RequestMethod.GET)
	public String editStudentProfile(Model model, @PathVariable int adm_no) {
	
		Student student=studentService.getstudentbyadm_no(adm_no);
		model.addAttribute("student", student);
		return "editstudentbyadmin";
	
	}
	
	
	@RequestMapping(value="/admin/editteacher/{id}", method=RequestMethod.POST)
	public String editteacher(@Valid @ModelAttribute("teacher") Teacher teacher , BindingResult result, Model model, @PathVariable int id)
	{
		if(result.hasErrors())
		{
			Teacher teacher2 =teacherService.getteacherbyid(id);
			model.addAttribute("teacher", teacher2);
			return "editteacherbyadmin";
		}
		else {
			teacherService.updateteacher(teacher, id);
			return "redirect:/admin";
		}
	}
	
	
	
	
	
	@RequestMapping(value="/admin/editStudent/{adm}",method=RequestMethod.POST)
	public String editStudentProfileProcess(@Valid @ModelAttribute("student") Student student,BindingResult result,Model model, @PathVariable int adm) {
		if(result.hasErrors()) {
			List<ObjectError> l1=result.getAllErrors();
			
			System.out.println(l1.get(0));
			Student sstudent=studentService.getstudentbyadm_no(student.getAdm_no());
			model.addAttribute("student", sstudent);
			return "editstudentbyadmin";
		}
		else {
			System.out.println("2");
			studentService.updatestudent(student, student.getAdm_no());
			return "redirect:/admin";
		}
		
	}
	
	
	@RequestMapping(value="/admin/addbusdetails", method=RequestMethod.GET)
	public String addbus(Model m)
	{
		Bus bus=new Bus();
		m.addAttribute("bus", bus);
		return "addbusdetails";
	}
	@RequestMapping(value="/admin/addbusdetails", method=RequestMethod.POST)
	public String addbus2(@Valid @ModelAttribute("bus") Bus bus, BindingResult result, Model m)
	{
		if(result.hasErrors())
		{
			Bus bus2=new Bus();
			m.addAttribute("bus", bus2);
			return "addbusdetails";
		}
		else {
			busService.addbus(bus);
			//System.out.print(bus.getDriver_name());
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="/admin/viewbusdetails", method = RequestMethod.GET)
	public String viewbusdetails(Model m)
	{
		List<Bus> list=busService.getallbus();
		m.addAttribute("buses", list);
		return "viewbusdetails";
	}
	
	@RequestMapping(value="/admin/viewbusdetails", method = RequestMethod.POST)
	public String viewbusdetailsp(@Valid @ModelAttribute("schooldata") School school, Model m)
	{
		List<Bus> list=busService.getbusbyschool_id(school.getSchool_id());
		m.addAttribute("buses", list);
		return "viewbusdetails";
	}
	
	
	
	
	
	@RequestMapping(value="/admin/deletebus/{bus_no}",method = RequestMethod.GET)
	public String deletebus(Model Model , @PathVariable int bus_no)
	{
		busService.deletebusbybus_no(bus_no);
		return "redirect:/admin/viewbusdetails";
	}
	
	@RequestMapping(value="/admin/viewbususers/{bus_no}",method = RequestMethod.GET)
	public String viewbususers(Model model , @PathVariable int bus_no)
	{
		List<Student> list1=studentService.getstudentbybus_no(bus_no);
		List<Teacher> list2=teacherService.getteacherbybus_no(bus_no);
		model.addAttribute("students",list1);
		model.addAttribute("teachers", list2);
		return "viewstudentsbybus";
	}
	
	@RequestMapping(value = "/admin/viewstudentprofile")
	public String welcome2(@Valid @ModelAttribute("adm_no") Integer adm_no,Model model, Principal principal) {
		        Student student=studentService.getstudentbyadm_no(adm_no);	
		        model.addAttribute("student",student);
		  model.addAttribute("topic","Student Profile");
			
			
			return "viewstudentprofile";
		
	}
	
	
	@RequestMapping("/admin/assignsubject/{id}")
	public String assignSubject(@ModelAttribute("classData")Subject subject, Model m, @PathVariable("id")
	int id) {
		
		List<Subject> subjects = subjectService.getsubjectbyclass_name(subject.getClass_name());
		m.addAttribute("subjects", subjects);
		Teacher teacher=teacherService.getteacherbyid(id);
		
		m.addAttribute("teacher", teacher);
		List<Teaches> teaches = teachesService.getTeachesByTeacher(id);
		List<Subject> assignedSubjects = new ArrayList<Subject>();
		for (int i = 0; i < teaches.size(); i++) {
			String sub_code = teaches.get(i).getSub_code();
			assignedSubjects.add(subjectService.getsubjectbysub_code(sub_code));
			subjects.remove(subjectService.getsubjectbysub_code(sub_code));
		}
		m.addAttribute("assignedsubjects", assignedSubjects);
		return "assignsubject";
	}
	
	@RequestMapping("/admin/assignsubject/process/{sub_code}/{teacher_id}") 
	public String assignSubjectProcess(@PathVariable("sub_code") String sub_code, @PathVariable("teacher_id")
	int teacher_id) {
		Teaches teaches = new Teaches();
		teaches.setTeacher_id(teacher_id);
		//teaches.setEmployee_id(employee_id);
		teaches.setSub_code(sub_code);
		//teaches.setSubject_id(subject_id);
		
		teaches.setId(0);
		String emp = Integer.toString(teacher_id);
		if(teachesService.addTeaches(teaches)) {
			return "redirect:/admin/assignsubject/" + emp;
		}
		else {
			return "redirect:/admin/assignsubject/" + emp;
		}
		
	}
	
	@RequestMapping("/admin/assignsubject/remove/{sub_code}/{teacher_id}")
	public String removeSubject(@PathVariable("sub_code") String sub_code, @PathVariable("teacher_id")
	int teacher_id) {
		String emp = Integer.toString(teacher_id);
		if(teachesService.deleteTeaches(teacher_id, sub_code)) {
			return "redirect:/admin/assignsubject/" + emp;
		}
		else {
			return "redirect:/admin/assignsubject/" + emp;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/admin/feestatus/{adm_no}/{fee_id}")
	public String payfees(@PathVariable("fee_id") int fee_id, @PathVariable("adm_no") int adm_no,Model m)
	{
	feeService.updatefeestatus(true, fee_id);
		 List<Fee> list=feeService.getfeedetails(adm_no);
		 m.addAttribute("list", list);
		 return "redirect:/admin/feestatus/"+adm_no; 
	}
	
	
	
	@RequestMapping(value="/admin/feestatus/{adm_no}", method=RequestMethod.GET)
	public String payfee(@PathVariable int adm_no, Model model)
	{
		 List<Fee> list=feeService.getfeedetails(adm_no);
		 model.addAttribute("list", list);
		 return "feestatus"; 
	}

	
	
}
