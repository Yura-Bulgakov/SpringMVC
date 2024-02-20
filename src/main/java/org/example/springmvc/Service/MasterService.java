package org.example.springmvc.Service;

import org.example.springmvc.entity.Department;
import org.example.springmvc.entity.Master;

import java.util.List;

public interface MasterService {
    Master create(Master master);

    void updateMaster(Master master);

    void deleteMaster(Long id);

    Master getMasterById(Long id);

    List<Master> getAllMasters();

    List<Department> getExistingDepartments();
}
