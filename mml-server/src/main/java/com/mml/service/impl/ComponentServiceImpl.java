package com.mml.service.impl;

import com.mml.dao.ComponentDao;
import com.mml.dao.ComponentDirDao;
import com.mml.domain.TResponse;
import com.mml.exceptions.DataException;
import com.mml.service.ComponentService;
import com.mml.utils.ToolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ComponentServiceImpl implements ComponentService {


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ComponentDao componentDao;
    @Autowired
    private ComponentDirDao componentDirDao;

    @Autowired
    private ToolUtil dirModuleUtil;
    private static TResponse tResponse = new TResponse();

    @Override
    public TResponse findById(Long id) {
        try{
            tResponse.getTResponse("oxs-pai-Component","zh_CN",componentDao.findById(id),true);
        }catch (DataException e){
            tResponse.getTResponse("oxs-pai-Component","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }

    @Override
    public TResponse findComponent(Long parentId) {
        try{
            tResponse.getTResponse("oxs-pai-ComponentAll","zh_CN",dirModuleUtil.getDirModule(componentDirDao.findByParentId(parentId),componentDao.findByParentId(parentId)),true);
        }catch (DataException e){
            tResponse.getTResponse("oxs-pai-ComponentAll","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }
}
