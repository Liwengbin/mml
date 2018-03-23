package com.mml.dao;

import com.mml.domain.jpa.NodeLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeLinkDao extends JpaRepository<NodeLink,Long> {
    NodeLink save(NodeLink nodeLink);
    NodeLink findById(Long id);
    NodeLink deleteAllBySource(Long sourceId);
    NodeLink deleteAllByTarget(Long targetId);
    NodeLink deleteById(Long id);
    NodeLink deleteAllByExperimentId(Long experimentId);
    List<NodeLink> findByExperimentId(Long experimentId);
}
