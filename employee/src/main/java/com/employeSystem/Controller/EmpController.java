package com.employeSystem.Controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employeSystem.entity.Department;
import com.employeSystem.entity.Employee;
import com.employeSystem.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService Service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List <Employee> emp=Service.getAllEmp();
		m.addAttribute("emp",emp);
		return "index";
	}
	@GetMapping("/addemp")
	public String addEmpform(Model m)
	{
		List<Department> deptList = Service.getAllDept();
		m.addAttribute("depts", deptList);
		return "add_emp";
	}
	@GetMapping("/add_dept")
	public String addEmpdept()
	{
		return "add_department";
	}
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session) {
		Service.addEmp(e);
		session.setAttribute("msg", "Emplyoee Added Sucessfully..");
		return "redirect:/";
	}
	@PostMapping("/dept_register")
	public String deptRegister(@ModelAttribute Department d, HttpSession session) {
		Service.addDept(d);
		session.setAttribute("msg", "Department Added Sucessfully..");
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = Service.getEMpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		Service.addEmp(e);
		session.setAttribute("msg", "Emp Data Update Sucessfully..");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id, HttpSession session) {

		Service.deleteEMp(id);
		session.setAttribute("msg", "Emp Data Delete Sucessfully..");
		return "redirect:/";
	}

	
}
