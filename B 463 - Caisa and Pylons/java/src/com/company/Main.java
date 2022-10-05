// Codeforces 463 B - Caisa and Pylons

// Link : https://codeforces.com/contest/463/problem/B


//package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfPylons = input.nextInt() + 1;
        int[] heights = new int[numberOfPylons];
        heights[0] = 0;
        for (int i = 1; i < numberOfPylons; i++) {
            heights[i] = input.nextInt();
        }
        int energy = 0;
        int dollars = 0;
        for (int i = 0; i < numberOfPylons - 1; i++) {

            energy += heights[i] - heights[i + 1];
            if (energy < 0) {
                dollars += -energy;
                energy = 0;
            }
        }

        System.out.println(dollars);
    }
}
