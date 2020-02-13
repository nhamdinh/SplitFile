package com;

import java.io.*;
import java.util.Scanner;

public class SplitFile {
    private static Scanner scanner = new Scanner(System.in);
    private static String PATH_FILE_INPUT;
    private static String PATH_OUTPUT;
    private static final String suffixPart = ".part";

    public static void enterPathFile() {
        System.out.println("Enter path FILE input: ");
        PATH_FILE_INPUT = scanner.nextLine();

        System.out.println("Enter path FILE output: ");
        PATH_OUTPUT = scanner.nextLine();

    }

    public static void splitFileBySize() {
        try {
            enterPathFile();

            System.out.println("Enter size(Mb): ");
            final long size = scanner.nextLong();
            final long sizeMega = 1024L * 1024L * size;


            File sourceFile = new File(PATH_FILE_INPUT);
            long sizeFileInput = sourceFile.length();

            InputStream inputStreamBySize = new FileInputStream(sourceFile);

            byte[] arr = new byte[1024];
            int b = 1;
            while ((inputStreamBySize.read()) != -1) {
                OutputStream outputStreamBySize = new FileOutputStream(
                        PATH_OUTPUT
                                + sourceFile.getName()
                                + suffixPart + b);

                int i;
                long d = 0;
                while ((i = inputStreamBySize.read(arr)) != -1) {
                    outputStreamBySize.write(arr, 0, i);
                    d += arr.length;
                    if (d >= sizeMega) {
                        break;
                    }
                }

                outputStreamBySize.flush();
                outputStreamBySize.close();
                if ((inputStreamBySize.read(arr)) == -1) {
                    System.out.println("DONE!!!");
                    System.out.println("Link file: " + PATH_OUTPUT);
                }
                b++;
                sizeFileInput = sizeFileInput - d;

            }

            inputStreamBySize.close();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public static void splitFileByNumBer() {
        try {
            enterPathFile();
            System.out.println("Enter number file: ");
            int numberFile = scanner.nextInt();

/**tao file*/

            File sourceFile = new File(PATH_FILE_INPUT);
            if (sourceFile.exists() && sourceFile.isFile()) {
/** tinh fileInput qua byte*/
                final long sizeFileInput = sourceFile.length();
                final long sizeFileOutputByNumber = (sizeFileInput / numberFile);

/**mo luong doc ghi*/

                InputStream inputStreamByNumber = new FileInputStream(sourceFile);
                byte[] arr = new byte[1024];

                for (int i = 1; i <= numberFile; i++) {
                    final int READ_ONE_KB = inputStreamByNumber.read(arr);
                    int sizeData = 0;
                    OutputStream outputStreamByNumber = new FileOutputStream(
                            PATH_OUTPUT
                                    + sourceFile.getName()
                                    + suffixPart + i);
                    while (READ_ONE_KB != 0) {
                        outputStreamByNumber.write(arr, 0, READ_ONE_KB);
                        sizeData += READ_ONE_KB;
                        if (sizeData >= sizeFileOutputByNumber) {
                            break;
                        }
                    }
                    System.out.println("The file is cut "
                            + sourceFile.getName() + suffixPart + i);

                    outputStreamByNumber.flush();
                    outputStreamByNumber.close();
                }
                System.out.println("The file is cut " + numberFile + " files");
                System.out.println("DONE!!!");
                System.out.println("Link file: " + PATH_OUTPUT);

                inputStreamByNumber.close();
            } else {
                System.out.println("File is NOT found!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}