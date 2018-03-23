package com.mml.controller;

import com.mml.domain.TResponse;
import com.mml.exceptions.MlException;
import com.mml.service.impl.NodeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@EnableAutoConfiguration
@RequestMapping("task.json")
public class TaskController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static TResponse tResponse;

    @Autowired
    private NodeServiceImpl nodeService;

    @RequestMapping(value = "run/{id}",method = RequestMethod.POST)
    @ResponseBody
    public TResponse Run(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) {
        return null;
    }

    @RequestMapping(value = "norun/addNode",method = RequestMethod.POST)
    @ResponseBody
    public TResponse registerNode(HttpServletRequest request, HttpServletResponse response,@RequestParam("ID") String ID,@RequestParam("nodeX") String X,@RequestParam("nodeY") String Y,@RequestParam("experimentId") String experimentId){
        try{
            tResponse = nodeService.registerNode(Long.valueOf(ID),Double.valueOf(X).intValue(),Double.valueOf(Y).intValue(),Long.valueOf(experimentId));
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }

    @RequestMapping(value = "norun/addNodeLink",method = RequestMethod.POST)
    @ResponseBody
    public TResponse registerNodeLink(HttpServletRequest request, HttpServletResponse response,@RequestParam("Target") String Target ,@RequestParam("Source") String Source,@RequestParam("outputPortId") String outputPortId,@RequestParam("inputPortId") String inputPortId,@RequestParam("experimentId") String experimentId){
        try{
        tResponse = nodeService.registerNodeLink(Long.valueOf(Source), Long.valueOf(outputPortId), Long.valueOf(Target), Long.valueOf(inputPortId), "ready", Long.valueOf(experimentId));
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }

    @RequestMapping(value = "norun/loadNode",method = RequestMethod.POST)
    @ResponseBody
    public TResponse getNode(HttpServletRequest request, HttpServletResponse response, @RequestParam("ID") String ID) {
        try{
        tResponse = nodeService.findNode(Long.valueOf(ID));
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }

    @RequestMapping(value = "norun/{method}",method = RequestMethod.GET)
    @ResponseBody
    public TResponse noRun(HttpServletRequest request, HttpServletResponse response, @PathVariable String method,@RequestParam("ID") String ID) {
        switch (method){
            case "getNodeState":
                    tResponse = nodeService.getNodeState(Long.valueOf(ID));
                break;
            case "loadNodeAll":
                tResponse = nodeService.findNodeAll(Long.valueOf(ID));
                break;
            case "deleteNode":
                tResponse = nodeService.deleteNode(Long.valueOf(ID));
                break;
            case "loadNodeLinkAll":
                tResponse = nodeService.findNodeLinkAll(Long.valueOf(ID));
                break;
            case "deleteNodeLink":
                tResponse = nodeService.deleteNodeLink(Long.valueOf(ID));
                break;
        }
        return tResponse;
    }
}
