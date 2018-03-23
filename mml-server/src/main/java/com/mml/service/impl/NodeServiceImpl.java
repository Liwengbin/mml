package com.mml.service.impl;

import com.mml.dao.*;
import com.mml.dao.impl.CustomDaoImpl;
import com.mml.domain.TResponse;
import com.mml.domain.TableData;
import com.mml.domain.jpa.*;
import com.mml.exceptions.DataException;
import com.mml.service.NodeService;
import com.mml.utils.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NodeServiceImpl implements NodeService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NodeDao nodeDao;
    @Autowired
    private NodeLinkDao nodeLinkDao;
    @Autowired
    private ComponentDao componentDao;
    @Autowired
    private CustomDaoImpl customDao;
    @Autowired
    private ComponentPortDao componentPortDao;
    @Autowired
    private ExperimentDao experimentDao;
    @Autowired
    private NodeStateDao nodeStateDao;
    @Autowired
    private NodeDataDao nodeDataDao;
    private static TResponse tResponse = new TResponse();

    @Override
    public TResponse registerNode(Long id,Integer x,Integer y,Long experimentId) {
        List<NodeInPort> inlist = new ArrayList<NodeInPort>();
        List<NodeOutPort> outlist = new ArrayList<NodeOutPort>();
        try {
            Component component = componentDao.findById(id);
            Node node = new Node();
            node.setName(component.getName());
            node.setDefName(component.getName());
            for (ComponentPort comport : component.getPorts()){
                if ( "in".equals(comport.getType())){
                    NodeInPort nodeinPort = new NodeInPort();
                    nodeinPort.setPort(comport.getPort());
                    nodeinPort.setSequence(comport.getSequence());
                    inlist.add(nodeinPort);
                }else {
                    NodeOutPort nodeoutPort = new NodeOutPort();
                    nodeoutPort.setPort(comport.getPort());
                    nodeoutPort.setSequence(comport.getSequence());
                    outlist.add(nodeoutPort);
                }
            }
            node.setStartTime(SystemUtil.getNowTime());
            node.setLastTime(SystemUtil.getNowTime());
            node.setExperimentId(experimentId);
            node.setPositionX(x);
            node.setPositionY(y);
            node.setCateGory(component.getCategory());
            node.setIcon(component.getIcon());
            node.setInNumber(component.getInNumber());
            node.setOutNumber(component.getOutNumber());
            node.setInPorts(inlist);
            node.setOutPorts(outlist);
            node = nodeDao.save(node);
            tResponse.getTResponse("oxs-pai-Node","zh_CN",node,true);
            NodeState nodeState = new NodeState(Integer.valueOf(1), "ready", node, experimentDao.findById(experimentId));
            nodeStateDao.save(nodeState);
        }catch (Exception e){
            e.getStackTrace();
            tResponse.getTResponse("oxs-pai-Node","zh_CN",e.getStackTrace(),false);
        }
        return tResponse;
    }

    @Override
    public TResponse findNode(Long id) {
        logger.info("node -> findNode id="+id);
        return tResponse.getTResponse("oxs-pai-Node","zh_CN",nodeDao.findById(id),true);
    }

    @Override
    public TResponse findNodeAll(Long experimentId) {
        return tResponse.getTResponse("oxs-pai-Node","zh_CN",nodeDao.findByExperimentId(experimentId),true);
    }

    @Override
    public TResponse deleteNode(Long id) {
        try {
            nodeDao.deleteById(nodeDao.findById(id));
            nodeLinkDao.deleteAllBySource(id);
            nodeLinkDao.deleteAllByTarget(id);
            tResponse.getTResponse("oxs-pai-Node","zh_CN",null,true);
        }catch (Exception e){
            tResponse.getTResponse("oxs-pai-Node","zh_CN",e.getMessage(),false);
        }
        return tResponse;
    }

    @Override
    public TResponse findNodeLink(Long id) {
        return tResponse.getTResponse("oxs-pai-NodeLink","zh_CN",nodeLinkDao.findById(id),true);
    }

    @Override
    public TResponse findNodeLinkAll(Long experimentId) {
        return tResponse.getTResponse("oxs-pai-NodeLink","zh_CN",nodeLinkDao.findByExperimentId(experimentId),true);
    }

    @Override
    public TResponse deleteNodeLink(Long id) {
        return tResponse.getTResponse("oxs-pai-NodeLink","zh_CN",nodeLinkDao.deleteById(id),true);
    }

    @Override
    public TResponse registerNodeLink(Long source, Long outputPortId, Long target, Long inputPortId, String type, Long experimentId) {
        NodeLink nodeLink = new NodeLink( source, outputPortId, target, inputPortId, type, experimentId);

        return tResponse.getTResponse("oxs-pai-NodeLink","zh_CN",nodeLinkDao.save(nodeLink),true);
    }

    @Override
    public TResponse getNodeState(Long experimentId) {
        return tResponse.getTResponse("oxs-pai-NodeState","zh_CN",customDao.getNodeState(experimentId),true);
    }

    @Override
    public TResponse getNodeRadarData(Long nodeId,Pageable pageable) {
        Node node = nodeDao.findById(nodeId);
        return tResponse.getTResponse("oxs-pai-NodeRadarData","zh_CN",nodeDataDao.findByNode(node,pageable),true);
    }

    @Override
    public TResponse getNodeLineBarData(Long nodeId, Pageable pageable) {
        Node node = nodeDao.findById(nodeId);
        return tResponse.getTResponse("oxs-pai-NodeRadarData","zh_CN",nodeDataDao.findByNode(node,pageable),true);
    }

    @Override
    public TResponse getNodeTableData(Long nodeId,Pageable pageable) {
        try{
            List<Object> nodes = new ArrayList<Object>();
            Node node = nodeDao.findById(nodeId);
            List<NodeData> nodeDatas = nodeDataDao.findByNode(node,pageable);
            TableData tableData = new TableData();
            for (NodeData nodeData:nodeDatas){
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("id",nodeData.getId());
                map.put("updateTime",nodeData.getUpdateTime());
                tableData.setTableHeader(nodeData.getTableHeader());
                for (int i=0;i<nodeData.getTableHeader().size();i++){
                    map.put(String.valueOf(nodeData.getTableHeader().get(i)),nodeData.getTableData().get(i));
                }
                nodes.add(map);
            }
            tableData.setTableContext(nodes);
            tResponse.getTResponse("oxs-pai-NodeData","zh_CN",tableData,true);
        }catch (DataException e){
            tResponse.getTResponse("oxs-pai-NodeData","zh_CN",e.getMessage(),false);
        }
        return tResponse;
    }

}
