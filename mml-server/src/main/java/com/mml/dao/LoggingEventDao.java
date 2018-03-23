package com.mml.dao;

import com.mml.domain.jpa.LoggingEvent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggingEventDao extends JpaRepository<LoggingEvent,Long> {
    @Query(nativeQuery = true, value = "select * from logging_event where caller_method like %?1% ORDER BY ?#{#pageable}",
            countQuery = "select count(*) from logging_event where caller_method like %?1%")
    List<LoggingEvent> findByCallerMethod(String caller_method,Pageable pageable);
}
