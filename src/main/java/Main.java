import files.FileInfo;
import files.FileReader;
import files.FileWriter;

import java.util.List;
import java.util.Scanner;

/**
 * @author luisdany pernillo
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Directory to analyze: ");
        String directory = scanner.nextLine();

        FileReader reader = new FileReader();
        List<FileInfo> fileList = reader.readFile(directory);
        System.out.println("Files read");

//        fileList.forEach(f -> System.out.println(f.toString()));

        System.out.println("Writing file...");
        FileWriter fileWriter = new FileWriter();
        fileWriter.writeFile(fileList);

    }

}
