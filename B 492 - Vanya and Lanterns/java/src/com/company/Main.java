// Codeforces 492 B - Vanya and Lanterns

// Link : https://codeforces.com/problemset/problem/492/B


//package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numberOfLanterns = input.nextInt();
        int streetLength = input.nextInt();
        boolean edgeCase = false;

        int[] locations = new int[numberOfLanterns];

        for (int i = 0; i < numberOfLanterns; i++) {
            locations[i] = input.nextInt();
        }

        Arrays.sort(locations);

        int maxSpace = 0;
        for (int i = 1; i < numberOfLanterns; i++) {
            if (locations[i] - locations[i - 1] > maxSpace) {
                maxSpace = locations[i] - locations[i - 1];
            }
        }


        if (locations[0] != 0) {
            if (locations[0] > maxSpace / 2.0) {
                maxSpace = locations[0];
                edgeCase = true;
            }
        }

        if (locations[numberOfLanterns - 1] != streetLength) {
            if (!edgeCase) {
                if (streetLength - locations[numberOfLanterns - 1] > maxSpace / 2.0) {
                    maxSpace = streetLength - locations[numberOfLanterns - 1];
                    edgeCase = true;
                }
            } else if (streetLength - locations[numberOfLanterns - 1] > maxSpace) {
                maxSpace = streetLength - locations[numberOfLanterns - 1];
            }

        }

        if (edgeCase) {
            System.out.println(maxSpace);
        } else {
            System.out.println(maxSpace / 2.0);
        }

    }


}

