package com.mml.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToolUtil {

    public List getDirModule(List dir, List file){
        dir.addAll(file);
        return dir;
    }

    public List<Object> getObjectList(String mail_str,String split){
        List temp=new ArrayList<String>();
        if(mail_str==null)
        {
            return null;
        }
        else
        {
            String[] strs=mail_str.split(split);
            for(int i=0;i<strs.length;i++)
            {
                temp.add(strs[i]);
            }
            return temp;
        }
    }
}
