package org.mancer;



import static org.junit.Assert.assertEquals;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class TextFileReverserTest {
    private TextFileReverser textFileReverser;
    private Path inputFilePath;
    private Path outputFilePath;

    @Before
    public void setUp() throws IOException {
        textFileReverser = new TextFileReverser();
        inputFilePath = Files.createTempFile("input", ".txt");
        outputFilePath = Files.createTempFile("output", ".txt");
    }

    @After
    public void tearDown() throws IOException {
        Files.deleteIfExists(inputFilePath);
        Files.deleteIfExists(outputFilePath);
    }

    @Test
    public void testReverse() {
        assertEquals("dcba", textFileReverser.reverse("abcd"));
        assertEquals("54321", textFileReverser.reverse("12345"));
        assertEquals("olleh", textFileReverser.reverse("hello"));
    }

    @Test
    public void testReverseFileContents() throws IOException {
        String inputContent = "Hello\nWorld";
        String expectedOutputContent = "dlroW\nolleH";

        // Write input content to the temporary file
        Files.write(inputFilePath, inputContent.getBytes(StandardCharsets.UTF_8));

        // Reverse the contents of the input file
        textFileReverser.reverseFileContents(inputFilePath.toString(), outputFilePath.toString());

        // Read the contents of the output file
        List<String> outputLines = Files.readAllLines(outputFilePath, StandardCharsets.UTF_8);

        // Verify the output content
        assertEquals(expectedOutputContent, String.join("\n", outputLines));
    }

    @Test(expected = FileNotFoundException.class)
    public void testReverseFileContentsFileNotFoundException() throws IOException {
        // Non-existent input file
        String nonexistentFilePath = "/path/to/nonexistent/file.txt";

        // Attempt to reverse non-existent file
        textFileReverser.reverseFileContents(nonexistentFilePath, outputFilePath.toString());
    }
}

