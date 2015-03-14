package com.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webapp.common.config.Global;
import com.webapp.dao.Page;
import com.webapp.model.Student;
import com.webapp.service.StudentService;


/**
 * studentController
 * @author ThinkGem
 * @version 2015-02-19
 */
@Controller
@RequestMapping(value = "${adminPath}/or/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@ModelAttribute
	public Student get(@RequestParam(required=false) String id) {
		System.out.println(id);
		if (StringUtils.isNotBlank(id)&&!id.equals("0")){
			return studentService.get(Integer.parseInt(id));
		}else{
			return new Student();
		}
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Student entity, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Student> page = studentService.find(new Page<Student>(request, response), entity); 
        model.addAttribute("page", page);
		return "modules/" + "or/studentList";
	}

	@RequestMapping(value = "form")
	public String form(Student student, Model model) {
		model.addAttribute("student", student);
		return "modules/" + "or/studentForm";
	}

	@RequestMapping(value = "save")
	public String save(Student student, Model model, RedirectAttributes redirectAttributes) {
		studentService.save(student);
		return "redirect:"+Global.getAdminPath()+"/or/student/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(Student entity, RedirectAttributes redirectAttributes) {
		studentService.delete(entity);
		 
		return "redirect:"+Global.getAdminPath()+"/or/student/?repage";
	}

}
