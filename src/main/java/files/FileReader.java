package files;

import check.CheckSum;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    private List<FileInfo> fileList;
    private FileWriter fileWriter = new FileWriter();


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
            if(file.isDirectory() && !file.getName().startsWith(".")){
                File[] files = file.listFiles();
                if(files != null)
                    Arrays.stream(files).parallel().forEach(this::getFiles2);
            }else if(!file.getName().startsWith(".")){

                if(fileList.size() > Integer.MAX_VALUE - 100){
                    fileWriter.writeFile(fileList);
                    fileList.clear();
                }

                FileInfo info = getInfoFile(file);
                System.out.printf("Adding file: %s%n", info.toString());
                fileList.add(info);
            }
        }
    }



    private FileInfo getInfoFile(File file){
        //String checkSum = CheckSum.getFileChecksum(file);
        return new FileInfo(file.getName(), file.getAbsolutePath(), file.length());
    }


}
