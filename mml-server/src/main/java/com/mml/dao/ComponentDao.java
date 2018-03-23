package com.mml.dao;

import com.mml.domain.jpa.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ComponentDao extends JpaRepository<Component,Long> {
    Component findById(Long id);

    List<Component> findByParentId(Long parentId);
}
