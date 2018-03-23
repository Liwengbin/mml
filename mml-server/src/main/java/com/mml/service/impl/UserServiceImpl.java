package com.mml.service.impl;

import com.mml.dao.LoggingEventDao;
import com.mml.dao.UserDao;
import com.mml.dao.impl.CustomDaoImpl;
import com.mml.domain.TResponse;
import com.mml.exceptions.DataException;
import com.mml.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;
    @Autowired
    private LoggingEventDao loggingEventDao;
    private static TResponse tResponse = new TResponse();
    @Override
    public void verification(Object obj){

    }

    @Override
    public TResponse findById(Long id) {
        logger.info("user -> findById");
        return tResponse.getTResponse("oxs-pai-user","zh_CN",userDao.findById(id),true);
    }

    @Override
    public TResponse getLogging(String caller_method,Pageable pageable) throws DataException {
        return tResponse.getTResponse("oxs-pai-getLogging","zh_CN",loggingEventDao.findByCallerMethod(caller_method, pageable),true);
    }

}
