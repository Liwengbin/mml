package com.mml.dao;

import com.mml.domain.jpa.StudentData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataDao extends JpaRepository<StudentData,Long> {

    List<StudentData> findByClassNameIn(String class_name, Pageable pageable);
}
