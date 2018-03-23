package com.mml.service;

import com.mml.domain.TResponse;
import org.springframework.data.domain.Pageable;

public interface NodeService {
    /**
     * 注册节点
     * @param id
     * @param x
     * @param y
     * @param experimentId
     * @return
     */
    public TResponse registerNode(Long id,Integer x,Integer y,Long experimentId);

    /**
     * 查询一个节点的具体信息
     * @param id
     * @return
     */
    public TResponse findNode(Long id);

    /**
     * 查询出这个实验的所有节点信息
     * @param experimentId
     * @return
     */
    public TResponse findNodeAll(Long experimentId);

    /**
     * 删除节点关系
     * @param id
     * @return
     */
    public TResponse deleteNode(Long id);

    /**
     * 查询节点关系
     * @param id
     * @return
     */
    public TResponse findNodeLink(Long id);

    /**
     * 查询节点关系all
     * @param experimentId
     * @return
     */
    public TResponse findNodeLinkAll(Long experimentId);

    /**
     * 删除节点关系
     * @param id
     * @return
     */
    public TResponse deleteNodeLink(Long id);

    /**
     * 注册节点关系
     * @param source
     * @param outputPortId
     * @param target
     * @param inputPortId
     * @param type
     * @param experimentId
     * @return
     */
    public TResponse registerNodeLink(Long source, Long outputPortId, Long target, Long inputPortId, String type, Long experimentId);

    public TResponse getNodeState(Long experimentId);

    /**
     * 表格数据
     * @param nodeId
     * @param pageable
     * @return
     */
    public TResponse getNodeTableData(Long nodeId,Pageable pageable);

    /**
     * 雷达图数据
     * @param nodeId
     * @param pageable
     * @return
     */
    public TResponse getNodeRadarData(Long nodeId,Pageable pageable);

    /**
     * 折线图，条形图数据
     * @param nodeId
     * @param pageable
     * @return
     */
    public TResponse getNodeLineBarData(Long nodeId,Pageable pageable);
}
