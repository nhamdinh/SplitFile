package com;

import java.io.*;
import java.util.Scanner;

public class JoinFile {
    static Scanner scanner = new Scanner(System.in);
    private static String PATH_FILE_INPUT;
    private static String PATH_OUTPUT;

    public static void joined() {
        try {
            System.out.println("Enter path FILE input: ");
            PATH_FILE_INPUT = scanner.nextLine();

            System.out.println("Enter path FILE output: ");
            PATH_OUTPUT = scanner.nextLine();

//            /**lay index tu 0 den het string*/
            int indexLastDotPath = PATH_FILE_INPUT.lastIndexOf(".");

            String fileName = PATH_FILE_INPUT.substring(0, indexLastDotPath);

            String suffixPath = PATH_FILE_INPUT.substring(indexLastDotPath + 1);

            File fileOutputJoin = new File(PATH_OUTPUT);
            OutputStream outputStream = new FileOutputStream(fileOutputJoin);

            byte[] arr = new byte[1024];
            int partIndex = 1;
            String fileNameParts = null;
            while (true) {
                if (suffixPath.startsWith("part")) {
                    fileNameParts = fileName + ".part" + partIndex;
                }
                File fileParts = new File(fileNameParts);
                if (fileParts.exists()) {
                    InputStream inputStream = new FileInputStream(fileNameParts);
                    int isCheckDataExist;
                    while ((isCheckDataExist = inputStream.available()) != 0) {
                        final int READ_ONE_KB = inputStream.read(arr);
                        outputStream.write(arr, 0, READ_ONE_KB);
                    }
                    System.out.println("Part " + partIndex + " joined!");
                    inputStream.close();
                    partIndex++;
                } else {
                    System.out.println("File joined successfully!");
                    break;
                }
            }
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}