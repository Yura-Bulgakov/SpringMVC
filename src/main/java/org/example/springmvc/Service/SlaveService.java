package org.example.springmvc.Service;

import org.example.springmvc.entity.Master;
import org.example.springmvc.entity.Slave;

import java.util.List;

public interface SlaveService {
    Slave create(Slave slave);

    void updateSlave(Slave slave);

    void deleteSlave(Long id);

    Slave getSlaveById(Long id);

    List<Slave> getAllSlaves();

    List<Slave> getAllSlavesByMasterId(Long id);

    List<Master> getExistingMasters();
}
