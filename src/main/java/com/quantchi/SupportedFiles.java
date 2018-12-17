package com.quantchi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SupportedFiles
 * @Description //
 * @Author wbchen
 * @Data 12/17/18 9:29 AM
 * @Version 1.0
 **/
public class SupportedFiles {
    private String path = "";

    private List<File> fileList = new ArrayList<File>();

    SupportedFiles(){}

    public SupportedFiles(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void getAllByPath(String path){
        File rootf = new File(path);
        if(rootf == null){
            System.out.print("");
        }


    }
}
