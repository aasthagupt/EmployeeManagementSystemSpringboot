package com.employeSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeSystem.entity.Department;
import com.employeSystem.entity.Employee;
import com.employeSystem.repository.DeptRepo;
import com.employeSystem.repository.EmpRepo;
@Service
public class EmpService {
	@Autowired
	private EmpRepo repo;
	
	@Autowired
	private DeptRepo deptrepo;
	
	public void addEmp(Employee e)
	{
		repo.save(e);
	}
	
	
	public void addDept(Department d)
	{
		deptrepo.save(d);
	}
	
	
	
	public List<Employee> getAllEmp() {
		return repo.findAll();
	}
	
	public List<Department> getAllDept() {
		return deptrepo.findAll();
	}
	
	public Employee getEMpById(int id) {
		Optional<Employee> e = repo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}
	public Department getDeptById(int id) {
		Optional<Department> d = deptrepo.findById(id);
		if (d.isPresent()) {
			return d.get();
		}
		return null;
	}
	
	public void deleteEMp(int id) {
		repo.deleteById(id);
	}
}
