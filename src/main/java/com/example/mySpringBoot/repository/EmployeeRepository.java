package com.example.mySpringBoot.repository;

import com.example.mySpringBoot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends Spring Data JPA’s JpaRepository, specifying the domain type as Employee and the id type as Long
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
