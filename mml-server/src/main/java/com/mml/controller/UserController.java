package com.mml.controller;

import com.mml.domain.TResponse;
import com.mml.exceptions.MlException;
import com.mml.service.impl.DataServiceImpl;
import com.mml.service.impl.ExperimentServiceImpl;
import com.mml.service.impl.NodeServiceImpl;
import com.mml.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@EnableAutoConfiguration
@RequestMapping("user.json")
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static TResponse tResponse = new TResponse();

    @Autowired
    private ExperimentServiceImpl experimentService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private DataServiceImpl dataService;

    @Autowired
    private NodeServiceImpl nodeService;

    @RequestMapping(value = "experiment/addExperiment",method = RequestMethod.POST)
    @ResponseBody
    public TResponse registerExperiment(HttpServletRequest request, HttpServletResponse response, @RequestParam("Name") String Name, @RequestParam("Region") String Region, @RequestParam("Desc") String Desc, @RequestParam("Address") String Address){
        try{
        tResponse = experimentService.registerExperiment(Name,Region,Desc,Long.valueOf(Address));
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }

    @RequestMapping(value = "data/getData",method = RequestMethod.POST)
    @ResponseBody
    public TResponse getData(HttpServletRequest request, HttpServletResponse response, @RequestParam("className") String className, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        try{
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page, size, sort);
            tResponse = dataService.findStudentData(className,pageable);
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }

    @RequestMapping(value = "data/getNodeTableData",method = RequestMethod.POST)
    @ResponseBody
    public TResponse getNodeTableData(HttpServletRequest request, HttpServletResponse response, @RequestParam("nodeId") Integer nodeId,@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        try{
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page, size, sort);
            tResponse = nodeService.getNodeTableData(Long.valueOf(nodeId),pageable);
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }

    @RequestMapping(value = "data/getNodeRadarData",method = RequestMethod.POST)
    @ResponseBody
    public TResponse getNodeRadarData(HttpServletRequest request, HttpServletResponse response, @RequestParam("nodeId") Integer nodeId,@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        try{
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page, size, sort);
            tResponse = nodeService.getNodeRadarData(Long.valueOf(nodeId),pageable);
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }

    @RequestMapping(value = "data/getNodeLineBarData",method = RequestMethod.POST)
    @ResponseBody
    public TResponse getNodeLineBarData(HttpServletRequest request, HttpServletResponse response, @RequestParam("nodeId") Integer nodeId,@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        try{
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            Pageable pageable = new PageRequest(page, size, sort);
            tResponse = nodeService.getNodeLineBarData(Long.valueOf(nodeId),pageable);
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }
    @RequestMapping(value = "user/getUserInformation",method = RequestMethod.POST)
    @ResponseBody
    public TResponse getUserInformation(HttpServletRequest request, HttpServletResponse response, @RequestParam("ID") String ID){
        try{
        tResponse = userService.findById(Long.valueOf(ID));
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }

    @RequestMapping(value = "log/getLogging",method = RequestMethod.POST)
    @ResponseBody
    public TResponse getLogging(HttpServletRequest request, HttpServletResponse response, @RequestParam("callerMethod") String callerMethod,@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "15") Integer size) {
        try{
            Sort sort = new Sort(Sort.Direction.DESC, "event_id");
            Pageable pageable = new PageRequest(page, size, sort);
            tResponse = userService.getLogging(callerMethod,pageable);
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }
}
