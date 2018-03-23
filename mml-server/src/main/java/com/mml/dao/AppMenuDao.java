package com.mml.dao;

import com.mml.domain.jpa.AppMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppMenuDao extends JpaRepository<AppMenu,Long>{
    @Override
    List<AppMenu> findAll();
}
