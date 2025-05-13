package com.pluralsight;

import java.util.Scanner;

public class Program {
   static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        userInterface.display(scanner);
    }
}
