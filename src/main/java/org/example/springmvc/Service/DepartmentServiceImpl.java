package org.example.springmvc.Service;

import org.example.springmvc.entity.Department;
import org.example.springmvc.exception.RecordNotFoundException;
import org.example.springmvc.logger.ServiceLogging;
import org.example.springmvc.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional
    @ServiceLogging
    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    @Transactional
    @ServiceLogging
    public void updateDepartment(Department updatedDepartment) {
        departmentRepository.save(updatedDepartment);
    }

    @Override
    @Transactional
    @ServiceLogging
    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);
    }

    @Override
    @ServiceLogging
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Отдел не найден"));
    }

    @Override
    @ServiceLogging
    public List<Department> getAllDepartments() {
        List<Department> departmentList = new ArrayList<>();
        departmentRepository.findAll().forEach(departmentList::add);
        return departmentList;
    }
}
