// Codeforces 102 B - Sum of Digits

// Link : https://codeforces.com/contest/102/problem/B


//package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String number = input.nextLine();

        System.out.println(sumDigits(number));
    }

    static int numberOfCalls = 0;

    public static int sumDigits(String number) {
        if (number.length() == 1) return 0;
        numberOfCalls += 1;
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i));
        }
        if (sum < 10) {
            return numberOfCalls;
        } else {
            return sumDigits(Integer.toString(sum));
        }
    }


}

