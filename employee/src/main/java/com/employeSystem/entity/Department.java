package com.employeSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Emp_Depart")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int department_id;
	private String department_loc;
	private String dept_name;
	
	public Department() {
		super();
	}
	
	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	
	public String getDept_name() {
		return dept_name;
	}
	

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDepartment_loc() {
		return department_loc;
	}

	public void setDepartment_loc(String department_loc) {
		this.department_loc = department_loc;
	}

	@Override
	public String toString() {
		return "Department [dept_name=" + dept_name + ", department_id=" + department_id + "]";
	}

	
}
