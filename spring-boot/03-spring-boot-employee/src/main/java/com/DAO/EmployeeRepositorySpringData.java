package com.DAO;

import com.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositorySpringData extends JpaRepository<Employee, Integer> {

}