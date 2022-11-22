// Drazil and Factorial

// https://codeforces.com/contest/515/problem/C


import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfDigits = input.nextInt();
        input.nextLine();
        String a = input.nextLine();
        ArrayList<Character> output = new ArrayList<Character>();
        for (int i = 0; i < numberOfDigits; i++) {
            switch (a.charAt(i)) {
                case '0':
                case '1':
                    break;
                case '2':
                    output.add('2');
                    break;
                case '3':
                    output.add('3');
                    break;
                case '4':
                    Collections.addAll(output, '3', '2', '2');
                    break;
                case '5':
                    output.add('5');
                    break;
                case '6':
                    Collections.addAll(output, '5', '3');
                    break;
                case '7':
                    output.add('7');
                    break;
                case '8':
                    Collections.addAll(output, '7', '2', '2', '2');
                    break;
                case '9':
                    Collections.addAll(output, '7', '3', '3', '2');
                    break;

            }

        }
        Collections.sort(output);
        for (int i = output.size() - 1; i >= 0; i--) {
            System.out.print(output.get(i));
        }

    }
}
