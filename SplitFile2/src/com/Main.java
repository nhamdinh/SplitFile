package com;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE_INPUT = "/home/tom/Desktop/HotelCalifornia.mp3";
    private static final String PATH_OUTPUT = "/home/tom/Desktop/day6/";

    public static void main(String[] args) throws IOException {

        do {

            System.out.println("nhap number file: ");
            int numberFile = scanner.nextInt();


            SplitFile sp = new SplitFile();
            sp.splitFileByNumBer(PATH_FILE_INPUT, PATH_OUTPUT, numberFile);

            System.out.println("cat duoc "+numberFile+" files");
            System.out.println("DONE!!!");
            System.out.println("Link file: " + PATH_OUTPUT);

        }
        while (true);
    }
}
