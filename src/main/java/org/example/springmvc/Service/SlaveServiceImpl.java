package org.example.springmvc.Service;

import org.example.springmvc.entity.Master;
import org.example.springmvc.entity.Slave;
import org.example.springmvc.exception.RecordNotFoundException;
import org.example.springmvc.repository.SlaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SlaveServiceImpl implements SlaveService {
    private final SlaveRepository slaveRepository;
    private final MasterService masterService;

    @Autowired
    public SlaveServiceImpl(SlaveRepository slaveRepository, MasterService masterService) {
        this.slaveRepository = slaveRepository;
        this.masterService = masterService;
    }

    @Override
    @Transactional
    public Slave create(Slave slave) {
        return slaveRepository.save(slave);
    }

    @Override
    @Transactional
    public void updateSlave(Slave slave) {
        slaveRepository.save(slave);
    }

    @Override
    @Transactional
    public void deleteSlave(Long id) {
        slaveRepository.deleteSlaveById(id);
    }

    @Override
    public Slave getSlaveById(Long id) {
        return slaveRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Подчиненный не найден"));
    }

    @Override
    public List<Slave> getAllSlaves() {
        List<Slave> slaves = new ArrayList<>();
        slaveRepository.findAll().forEach(slaves::add);
        return slaves;
    }

    @Override
    public List<Slave> getAllSlavesByMasterId(Long id) {
        return slaveRepository.findAllByMasterId(id);
    }

    @Override
    public List<Master> getExistingMasters() {
        return masterService.getAllMasters();
    }
}
