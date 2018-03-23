package com.mml.dao;

import com.mml.domain.jpa.ComponentDir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ComponentDirDao extends JpaRepository<ComponentDir,Long> {
    List<ComponentDir> findByParentId(Long parentId);
}
