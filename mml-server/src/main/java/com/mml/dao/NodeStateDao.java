package com.mml.dao;

import com.mml.domain.jpa.NodeState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeStateDao extends JpaRepository<NodeState,Long> {
    NodeState save(NodeState nodeState);
}
