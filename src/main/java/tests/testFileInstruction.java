package tests;

import com.quantchi.SupportedFiles;

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
        }

    }
}
