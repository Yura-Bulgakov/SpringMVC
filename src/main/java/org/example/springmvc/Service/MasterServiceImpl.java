package org.example.springmvc.Service;

import org.example.springmvc.entity.Department;
import org.example.springmvc.entity.Master;
import org.example.springmvc.exception.RecordNotFoundException;
import org.example.springmvc.logger.ServiceLogging;
import org.example.springmvc.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MasterServiceImpl implements MasterService {
    private final MasterRepository masterRepository;
    private final DepartmentService departmentService;

    @Autowired
    public MasterServiceImpl(MasterRepository masterRepository, DepartmentService departmentService) {
        this.masterRepository = masterRepository;
        this.departmentService = departmentService;
    }

    @Override
    @Transactional
    @ServiceLogging
    public Master create(Master master) {
        return masterRepository.save(master);
    }

    @Override
    @Transactional
    @ServiceLogging
    public void updateMaster(Master master) {
        masterRepository.save(master);
    }

    @Override
    @Transactional
    @ServiceLogging
    public void deleteMaster(Long id) {
        masterRepository.deleteMasterById(id);
    }

    @Override
    @ServiceLogging
    public Master getMasterById(Long id) {
        return masterRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Руководитель не найден"));
    }

    @Override
    @ServiceLogging
    public List<Master> getAllMasters() {
        List<Master> masters = new ArrayList<>();
        masterRepository.findAll().forEach(masters::add);
        return masters;
    }

    @Override
    @ServiceLogging
    public List<Department> getExistingDepartments() {
        return departmentService.getAllDepartments();
    }
}
