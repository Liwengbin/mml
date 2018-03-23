package com.mml.service.impl;

import com.mml.dao.AppMenuDao;
import com.mml.domain.TResponse;
import com.mml.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {
    private static TResponse tResponse = new TResponse();
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppMenuDao appMenuDao;

    @Override
    public TResponse findAppMenu() {
        logger.info("init ->findAppMenu");
        return tResponse.getTResponse("oxs-pai-appMenu","zh_CN",appMenuDao.findAll(),true);
    }
}
