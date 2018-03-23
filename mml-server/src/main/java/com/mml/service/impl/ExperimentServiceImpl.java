package com.mml.service.impl;

import com.mml.dao.ExperimentDao;
import com.mml.dao.ExperimentDirDao;
import com.mml.domain.Dir;
import com.mml.domain.jpa.Experiment;
import com.mml.domain.jpa.ExperimentDir;
import com.mml.domain.TResponse;
import com.mml.exceptions.DataException;
import com.mml.service.ExperimentService;
import com.mml.utils.ToolUtil;
import com.mml.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperimentServiceImpl implements ExperimentService {

    @Autowired
    private ExperimentDao experimentDao;

    @Autowired
    private ExperimentDirDao experimentDirDao;

    @Autowired
    private ToolUtil dirModuleUtil;

    private static TResponse tResponse = new TResponse();

    @Override
    public TResponse findById(Long id) {
        return tResponse.getTResponse("oxs-pai-Experiment","zh_CN",experimentDao.findById(id),true);
    }

    @Override
    public TResponse findExperiment(Long parentId) {


        //DataModel dataModel = new DataModel(experimentDirDao.findByParentId(parentId),experimentDao.findByParentId(parentId));
        return tResponse.getTResponse("oxs-pai-ExperimentAll","zh_CN",dirModuleUtil.getDirModule(experimentDirDao.findByParentId(parentId),experimentDao.findByParentId(parentId)),true);
    }

    @Override
    public TResponse findExperimentDir(Long parentId) {
        try {
            tResponse.getTResponse("oxs-pai-Experiment","zh_CN",returnExperimentDir(parentId),true);
        }catch (DataException e){
            tResponse.getTResponse("oxs-pai-Experiment","zh_CN",e.getStackTrace(),false);
        }
        return tResponse;
    }

    @Override
    public TResponse registerExperiment(String name, String projectName, String description, Long parentId) {
        try {
            Experiment experiment = new Experiment();
            experiment.setCreatedTime(SystemUtil.getNowTime());
            experiment.setLastUpdateTime(SystemUtil.getNowTime());

            experiment.setName(name);
            experiment.setProjectName(projectName);
            experiment.setDescription(description);
            experiment.setParentId(parentId);

            experiment.setDir(false);
            experiment.setIcon("ml-icon-shiyan");
            tResponse.getTResponse("oxs-pai-Experiment","zh_CN",experimentDao.save(experiment),true);
        }catch (DataException e){
            tResponse.getTResponse("oxs-pai-Experiment","zh_CN",e.getStackTrace(),false);
        }
        return tResponse;
    }

    /**
     * 创建Dir的List
     * @param parentId
     * @return
     */
    private List<Dir> returnExperimentDir(Long parentId){
        List<ExperimentDir> experimentDirs = experimentDirDao.findByParentId(parentId);
        List<Dir> dirs = new ArrayList<Dir>();
        if (experimentDirs.size()>0) {
            for (ExperimentDir item : experimentDirs) {
                Dir dir = new Dir(item.getId(), item.getName(), returnExperimentDir(item.getId()));
                dirs.add(dir);
            }
        }
        return dirs;
    }

}
