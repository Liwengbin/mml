package com.mml.controller;

import com.mml.domain.TResponse;
import com.mml.service.impl.AppServiceImpl;
import com.mml.service.impl.ExperimentServiceImpl;
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
@RequestMapping("app.json")
public class AppController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static Date now = new Date(System.currentTimeMillis());

    private static TResponse tResponse = new TResponse();

    @Autowired
    private ExperimentServiceImpl experimentService;

    @Autowired
    private AppServiceImpl appService;

    @RequestMapping(value = "menu",method = RequestMethod.GET)
    @ResponseBody
    public TResponse module(HttpServletRequest request, HttpServletResponse response){//@RequestParam("method") String method

        tResponse = appService.findAppMenu();
        return tResponse;
    }

}
