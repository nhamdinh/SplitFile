package com;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        String choose;
        boolean exit = false;
        SplitFile splitFile = new SplitFile();
        JoinFile joinFile = new JoinFile();
        FileManager.showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    splitFile.splitFileBySize();
                    break;
                case "2":
                    splitFile.splitFileByNumBer();
                    break;
                case "3":
                    joinFile.joined();
                    break;
                case "0":
                    System.out.println("Exit!!!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid! please choose action in below menu:");
            }
            if (exit) {
                break;
            }
            FileManager.showMenu();
        }
    }
}
