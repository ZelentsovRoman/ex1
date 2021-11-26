import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] words = new String[25][30];
        createFileList("src/main/resources/text.txt");
        writeInFile("src/main/resources/text.txt");
        readFile(words);
        showStudentsWithAbsence(words);
    }

    public static void writeInFile(String s) throws IOException {
        String fileData = "Surname1 + - + - + + + + + + + + + +\n" +
                "Surname2 + + + + + + + + + + + + + +\n" +
                "Surname3 + - + - + + + + + + + - - -\n" +
                "Surname4 + + + + + + + + + + + + + -";
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/text.txt"));
        writer.write(fileData);
        writer.close();
    }

    public static File createFileList(String s) throws IOException {
        File f = new File(s);
        f.createNewFile();
        return f;
    }

    public static void showStudentsWithAbsence(String[][] arr) {
        System.out.println("Students with absence");
        Stream.of(arr).map(Arrays::toString).filter(x -> x.contains("-")).forEach(System.out::println);
    }

    public static void readFile(String[][] arr) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/main/resources/text.txt"));
        String s;
        int i=0;
        while(in.hasNextLine()){
            s = in.nextLine();
            arr[i] = s.split(" ");
            i++;
        }
        in.close();
    }
}
