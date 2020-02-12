package com;

import java.io.*;

public class SplitFile {
    private static final String suffix = "_split.Part";


    public void splitFileByNumBer(String PATH_FILE_INPUT,
                                  String PATH_OUTPUT,
                                  int numberFile) throws IOException {


        File sourceFile = new File(PATH_FILE_INPUT);
        if (sourceFile.exists() && sourceFile.isFile()) {


            final long sizeSplitFileInput = sourceFile.length();
            final long sizeSplitFileOutput = (sizeSplitFileInput / numberFile);



            InputStream inputStreamByNumber = new FileInputStream(sourceFile);
            byte[] arr = new byte[100];

            for (int i = 1; i <= numberFile; i++) {
                int j = inputStreamByNumber.read(arr);
                long a = 0;
                OutputStream outputStreamByNumber = new FileOutputStream(
                        PATH_OUTPUT
                                + sourceFile.getName()
                                + suffix + i);
                System.out.println("file cắt được " + sourceFile.getName() + suffix + i);
                while (j != -1) {
                    outputStreamByNumber.write(arr, 0, j);
                    a += j;
                    if (a >= sizeSplitFileOutput) {
                        break;
                    }
                }
                outputStreamByNumber.flush();
                outputStreamByNumber.close();
            }
            inputStreamByNumber.close();
//            return true;
        } else {
            System.out.println("File is NOT found!!!");
//            return false;
        }
    }
}