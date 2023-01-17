package com.employeSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeSystem.entity.Department;
@Repository
public interface DeptRepo extends JpaRepository<Department,Integer>{

}
