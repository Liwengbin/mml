package com.mml.dao;

import com.mml.domain.jpa.Experiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExperimentDao extends JpaRepository<Experiment,Long>{
    Experiment findById(Long id);

    List<Experiment> findByParentId(Long parentId);

    Experiment save(Experiment experiment);
}
