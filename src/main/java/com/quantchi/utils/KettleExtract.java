package com.quantchi.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
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

        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(kettle));

            String sql = null;
            int line = 1;
            while((sql = reader.readLine()) != null){
                if(sql.contains("<sql>")){
                    System.out.println("==== " + line + " :" + sql.replaceAll("&#x.{1,3};", " "));
                    System.out.println("line " + line + " :" + sql);
                }


                line++;
//                if(line > 10000){
//                    break;
//                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                reader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
//        int BUFFER_SIZE = 4096;
//        String fileName = filePath;
//        long fileLength = new File(fileName).length();
//        int bufferCount = 1 + (int) (fileLength / BUFFER_SIZE);
//        MappedByteBuffer[] buffers = new MappedByteBuffer[bufferCount];
//
//        long remaining = fileLength;
//        for(int i = 0;i < bufferCount;i++){
//            RandomAccessFile file;
//            try{
//                file = new RandomAccessFile(fileName,"r");
//                buffers[i] = file.getChannel().map(FileChannel.MapMode.READ_ONLY, i * BUFFER_SIZE, (int)Math.min(remaining,BUFFER_SIZE));
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            remaining -= BUFFER_SIZE;
//        }

    }
}
