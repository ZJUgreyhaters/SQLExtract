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
        File f = new File("/home/wbchen/Documents/FILE/script");
//        if(f.isFile()){
//            System.out.println("333" + f.getAbsolutePath() + "    name " + f.getName());
//            return;
//        }
//        File[] s = f.listFiles();
//
//        for (File tmp :
//             s) {
//            if(tmp.isDirectory()){
//                System.out.println("Dir :" + tmp.getAbsolutePath());
//            }else{
//                System.out.println("File:" + tmp.getName());
//            }
//        }
//        return;

        List<File> files =  (new SupportedFiles("/home/wbchen/Documents/FILE/script")).getFileList();



    }
}
