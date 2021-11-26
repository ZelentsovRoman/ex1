import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("В классе Main")
public class test {
    String[][] testArray = new String[25][30];
    File file;

    @DisplayName("корректно создается файл")
    @Test
    void createFileListTest() throws IOException {
        file = Main.createFileList("src/test/java/test.txt");
        String absolutePath = file.getAbsolutePath();
        assertTrue(absolutePath.endsWith("test.txt"));
    }

    @DisplayName("корректно записывается текст в файл")
    @Test
    void writeInFileTest() throws IOException {
        file = Main.createFileList("src/test/java/test.txt");
        Main.writeInFile("src/test/java/test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
        assertNotNull(br.readLine());
    }

    @DisplayName("корректно читается файл")
    @Test
    void readFileTest() throws IOException {
        file = Main.createFileList("src/test/java/test.txt");
        Main.writeInFile("src/test/java/test.txt");
        Main.readFile(testArray);
        assertEquals("Surname1",testArray[0][0]);
    }

    @DisplayName("корректно выводится список студентов с пропусками")
    @Test
    void showStudentsWithAbsenceTest() throws IOException {
        file = Main.createFileList("src/test/java/test.txt");
        Main.writeInFile("src/test/java/test.txt");
        Main.readFile(testArray);
        Main.showStudentsWithAbsence(testArray);
    }

}
