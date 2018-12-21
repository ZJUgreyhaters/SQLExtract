package tests;

import com.quantchi.utils.KettleExtract;
import com.quantchi.utils.SupportedFiles;

import java.io.File;
import java.util.List;


/**
 * @ClassName testFileInstruction
 * @Description //
 * @Author wbchen
 * @Data 12/17/18 9:57 AM
 * @Version 1.0
 **/
public class testFileInstruction {
    public static void main(String[] args){

        List<File> files =  (new SupportedFiles("/home/wbchen/Documents/FILE/script")).getFileList();

        for(int i = 0;i < files.size();i++){
            System.out.println(files.get(i).getName());
            if(files.get(i).getName().contains("kettle")){
                KettleExtract kettleExtract = new KettleExtract(files.get(i).getAbsolutePath());
                List<String> sqls = kettleExtract.getSqls();

                for(int m = 0;m < sqls.size();m++){
                    System.out.println("->" + sqls.get(m));
                }
            }else if(files.get(i).getName().contains(".sql")){

            }
        }

    }
}
