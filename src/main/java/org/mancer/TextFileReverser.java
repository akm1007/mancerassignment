package org.mancer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextFileReverser {
    public String reverse(String input) {
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }


    public void reverseFileContents(String inputFilePath, String outputFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            List<String> reversedLines=new ArrayList<String>();
            reader.lines().map(this::reverse).forEach(reversedLines::add);
            Collections.reverse(reversedLines);
            reversedLines.forEach(line -> {
                try {
                    writer.write(line);
                    writer.newLine();
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });
        }
    }
}
