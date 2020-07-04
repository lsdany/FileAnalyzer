package files;

import check.CheckSum;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    private List<FileInfo> fileList;

    public FileReader(){
        fileList = new ArrayList<>();
    }

    public List<FileInfo> readFile(String pathName){
        System.out.println("Reading files from: "+ pathName);
        getFiles2(new File(pathName));
        return fileList;
    }


    private void getFiles(File file){
        if(file.exists()){
            File[] files = file.listFiles();
            for(File f : files){
                if(f.isDirectory()){
                    getFiles(f);
                }else{
                    fileList.add(getInfoFile(f));
                }
            }
        }
    }


    private void getFiles2(File file){
        if(file != null && file.exists()){
            if(file.isDirectory() ){
                File[] files = file.listFiles();
                if(files != null)
                    Arrays.stream(files).parallel().forEach(this::getFiles2);
            }else{
                fileList.add(getInfoFile(file));
            }
        }
    }



    private FileInfo getInfoFile(File file){
        String checkSum = CheckSum.getFileChecksum(file);

        return new FileInfo(file.getAbsolutePath(), file.length(), checkSum);
    }


}
