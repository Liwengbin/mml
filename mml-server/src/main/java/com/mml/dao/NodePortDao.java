package com.mml.dao;

import com.mml.domain.jpa.NodeInPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodePortDao extends JpaRepository<NodeInPort,Long> {
    public NodeInPort save(NodeInPort nodePort);
}
