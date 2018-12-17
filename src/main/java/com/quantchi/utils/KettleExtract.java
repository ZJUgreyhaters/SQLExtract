package com.quantchi.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName KettleExtract
 * @Description //
 * @Author wbchen
 * @Data 12/17/18 1:11 PM
 * @Version 1.0
 **/
public class KettleExtract {
    private String filePath = "";
    private List<String> sqls = new ArrayList<String>();

    KettleExtract(){}

    public KettleExtract(String filePath){
        this.filePath =filePath;
    }

    public List<String> getSqls() {
        extractSQL(this.filePath);
        return sqls;
    }

    private void extractSQL(String filePath){

        File kettle = new File(filePath);

        if(kettle == null){
            return;
        }


    }
}
