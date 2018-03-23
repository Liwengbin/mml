package com.mml.dao;

import com.mml.domain.jpa.ExperimentDir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExperimentDirDao extends JpaRepository<ExperimentDir,Long> {
    List<ExperimentDir> findByParentId(Long parentId);
}
