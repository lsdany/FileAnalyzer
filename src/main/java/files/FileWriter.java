package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileWriter {

    private final String FILE_NAME = "files.txt";

    public void writeFile(List<FileInfo> fileInfoList){

        try {
            Files.write(Paths.get(FILE_NAME), fileInfoList.stream()
                    .map(FileInfo::toString)
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Problem writing the file..." + e.getLocalizedMessage());
        }

    }
}
