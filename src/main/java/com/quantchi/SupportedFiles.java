package com.quantchi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SupportedFiles
 * @Description //traversal the path to list all file supported('.sql', 'skettle', '.scala' ...).
 * @Author wbchen
 * @Data 12/17/18 9:29 AM
 * @Version 1.0
 **/
public class SupportedFiles {
    //private static final Logger logger = Logger.getLogger(SupportedFiles.class);

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

    /**
     * @Author      wbchen
     * @Description
     * @Date        9:50 AM 12/17/18
     * @Param       [path]
     * @return      void
     **/
    public void traversalFilesByPath(String path){

        File rootf = new File(path);
        if(rootf == null){
            System.out.print("The file path does not exist or has syntax error, please check first.");
            //logger.warn("The file path does not exist or has syntax error, please check first.");
        }

        File[] filesUnderThisPath = rootf.listFiles();
        if(filesUnderThisPath == null || filesUnderThisPath.length <= 0){
            System.out.println("The folder is empty.");
            //logger.warn("The folder is empty.");
        }else{
            for (File tmp : filesUnderThisPath) {
                if(tmp.isDirectory()){
                    traversalFilesByPath(tmp.getPath());
                }else if(FileType.isSupportedType(tmp)){
                    fileList.add(tmp);
                }
            }
        }
    }

    public List<File> getFileList(){
        traversalFilesByPath(this.path);
        return this.fileList;
    }
}
