package org.example.springmvc.repository;

import org.example.springmvc.entity.Slave;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlaveRepository extends CrudRepository<Slave, Long> {
    List<Slave> findAllByMasterId(Long masterId);

    void deleteSlaveById(Long id);
}
