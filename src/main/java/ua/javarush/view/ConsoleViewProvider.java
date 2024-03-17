package ua.javarush.view;

import java.util.Scanner;

public class ConsoleViewProvider {
    private final Scanner scanner = new Scanner(System.in);

    public String getMessage() {
        return scanner.next();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
