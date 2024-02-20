package org.example.springmvc.Service;

import org.example.springmvc.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department create(Department department);

    void updateDepartment(Department updatedDepartment);

    void deleteDepartment(Department department);

    Department getDepartmentById(Long id);

    List<Department> getAllDepartments();
}
