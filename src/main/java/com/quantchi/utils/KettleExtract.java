package com.quantchi.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

                    System.out.println("line  " + line + " :" + sql);
                    int index = 0;
                    while((index = sql.indexOf("&#x")) != -1){
                        int front  = index;
                        int end = index;
                        if(sql.charAt(front + 4) == ';'){
                            end = front + 4;
                        }else if(sql.charAt(front + 5) == ';'){
                            end = front + 5;
                        }else if(sql.charAt(front + 7) == ';'){
                            end = front + 7;
                        }
                        // "...&#x--;..."
                        String ascii = sql.substring(front + 3, end);

                        sql = sql.substring(0, front) + String.valueOf((char)(Integer.parseInt(ascii, 16))) + sql.substring(end + 1);
                    }
                    //System.out.println("progreess : " + sql);
                    this.sqls.add(sql);
                }

                line++;
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
