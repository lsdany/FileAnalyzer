import java.util.Scanner;

/**
 * @author luisdany pernillo
 */
public class Main {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            boolean continueMenu = true;
            while (continueMenu){
                System.out.println("Options");
                System.out.println("1. Analyze Directory");
                System.out.println("2.Check File");
                System.out.println("3. Exit");
                int option = scanner.nextInt();

                switch (option) {
                    case 1 -> analyzeDirectory();
                    case 2 -> checkFile();
                    default -> continueMenu = false;
                }
            }
        }





    }

    private static void checkFile() {
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("File to analyze");
            String file = scanner.nextLine();

        }
    }

    private static void analyzeDirectory() {
        System.out.println("analyzeDirectory");
//        System.out.println("Directory to analyze: ");
//        String directory = scanner.nextLine();
//
//        FileReader reader = new FileReader();
//        List<FileInfo> fileList = reader.readFile(directory);
//        System.out.println("Files read");
//
////        fileList.forEach(f -> System.out.println(f.toString()));
//
//        System.out.println("Writing file...");
//        FileWriter fileWriter = new FileWriter();
//        fileWriter.writeFile(fileList);
    }

}
