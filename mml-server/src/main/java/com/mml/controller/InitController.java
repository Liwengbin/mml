package com.mml.controller;

import com.mml.domain.TResponse;
import com.mml.exceptions.MlException;
import com.mml.service.impl.ComponentServiceImpl;
import com.mml.service.impl.ExperimentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@EnableAutoConfiguration
@RequestMapping("init.json")
public class InitController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static TResponse tResponse = new TResponse();

    @Autowired
    private ExperimentServiceImpl experimentService;

    @Autowired
    private ComponentServiceImpl componentService;

    @RequestMapping(value = "experiment/{method}",method = RequestMethod.GET)
    @ResponseBody
    public TResponse experiment(HttpServletRequest request, HttpServletResponse response, @PathVariable String method, @RequestParam("ID") String ID){//@RequestParam("method") String method
        try{
            Long L_ID = Long.valueOf(ID);
            switch (method)
            {
                case "getExperiment":
                    tResponse = experimentService.findById(L_ID);
                    break;
                case "getExperimentDir":
                    tResponse = experimentService.findExperiment(L_ID);
                    break;
                case "getDir":
                    tResponse = experimentService.findExperimentDir(L_ID);
                    break;
                default:
                    tResponse.getTResponse("oxs-pai-Info","zh_CN","method Parameters are empty or no corresponding values! ",false);
                    logger.info("method Parameters are empty or no corresponding values!");
                    break;
            }
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }

        return tResponse;
    }

    @RequestMapping(value = "component/{method}",method = RequestMethod.GET)
    @ResponseBody
    public TResponse component(HttpServletRequest request, HttpServletResponse response, @PathVariable String method, @RequestParam("ID") String ID){//@RequestParam("method") String method
        try{
            Long L_ID = Long.valueOf(ID);
            switch (method)
            {
                case "getComponent":
                    tResponse = componentService.findById(L_ID);
                    break;
                case "getComponentDir":
                    tResponse = componentService.findComponent(L_ID);
                    break;
                default:
                    tResponse.getTResponse("oxs-pai-Info","zh_CN","method Parameters are empty or no corresponding values! ",false);
                    logger.info("method Parameters are empty or no corresponding values!");
                    break;
            }
        }catch (MlException e){
            tResponse.getTResponse("oxs-pai-MlException","zh_CN",e.getMessage(),false);
            logger.error(e.getMessage());
        }
        return tResponse;
    }
}
