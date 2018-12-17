package com.quantchi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SupportedFileList {

    private String path = "";

    private List<File> fileList = new ArrayList<>();

    SupportedFileList(){}

    public SupportedFileList(String path){
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
