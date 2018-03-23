package com.mml.dao;

import com.mml.domain.jpa.Node;
import com.mml.domain.jpa.NodeData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeDataDao extends JpaRepository<NodeData,Long> {

    List<NodeData> findByNode(Node node, Pageable pageable);

}
