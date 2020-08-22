package check;

import files.FileInfo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author luisdany
 */
public class FileCheck {

    public static void main(String[] args) throws IOException, URISyntaxException {
        FileCheck file = new FileCheck();
        file.readFile();
    }

    private void readFile() throws IOException, URISyntaxException {
        Path path = Paths.get("/home/luisdany/files.txt");

        Stream<String> lines = Files.lines(path);
        List<String> files = lines.collect(Collectors.toList());
        lines.close();

        for(String file : files){

        }
    }

    private FileInfo parse(final String file){
        // filePath=/run/media/luisdany/LsDany/test/IdeaProjects/jhipsStudents/node_modules/read-chunk/index.js, size=914, fileName=index.js
        String[] fileInf = file.split(",");
        String path = fileInf[0].split("=")[1];
        String size = fileInf[1].split("=")[1];
        String name = fileInf[2].split("=")[1];
        return new FileInfo(name, path, Long.getLong(size));
    }
}
