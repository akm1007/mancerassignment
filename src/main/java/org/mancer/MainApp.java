package org.mancer;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainApp {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give input file path");
        String inputFilePath = scanner.nextLine();
        if(inputFilePath.isEmpty()){
            System.out.println("Input file name can not be empty, exiting application");
            System.exit(0);
        }
        System.out.println("Give output file path");

        String outFilePath = scanner.nextLine();
        if(outFilePath.isEmpty()){
            System.out.println("output file name can not be empty, exiting application");
            System.exit(0);
        }
        TextFileReverser reverser= new TextFileReverser();

        reverser.reverseFileContents(inputFilePath,outFilePath);
   }
}