//package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfGames = input.nextInt();
        input.nextLine();
        String status = input.nextLine();
        int anton = 0, danik = 0;
        for (int i = 0; i < numberOfGames; i++) {
            if (status.charAt(i) == 'A') {
                ++anton;
            } else if (status.charAt(i) == 'D') {
                ++danik;
            }
        }
        if (anton > danik)
            System.out.print("Anton");
        else if (anton < danik)
            System.out.print("Danik");
        else
            System.out.print("Friendship");
    }
}
