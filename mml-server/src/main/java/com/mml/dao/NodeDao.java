package com.mml.dao;

import com.mml.domain.jpa.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeDao extends JpaRepository<Node,Long> {
    List findByExperimentId(Long experimentId);
    Node findById(Long id);
    Node save(Node node);
    Node deleteById(Node node);
}
