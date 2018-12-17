package com.quantchi;

import java.io.File;

/**
 * @ClassName FileType
 * @Description //
 * @Author wbchen
 * @Data 12/17/18 1:08 PM
 * @Version 1.0
 **/
public class FileType {

    private static final String HSQL = ".sql";
    private static final String KETTLE = "";
    private static final String SCALA = ".scala";

    public static boolean isSupportedType(File file){
        if(file == null){
            return false;
        }

        String fileName = file.getName();

        if(fileName.endsWith(HSQL) || fileName.endsWith(SCALA)){
            return true;
        }

        return false;
    }

}
