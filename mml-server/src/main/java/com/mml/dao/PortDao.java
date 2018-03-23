package com.mml.dao;

import com.mml.domain.jpa.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortDao extends JpaRepository<Port,Long> {
    public Port save(Port port);
}
