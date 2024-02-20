package org.example.springmvc.repository;

import org.example.springmvc.entity.Master;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends CrudRepository<Master, Long> {
    void deleteMasterById(Long id);
}
