// Steps

// https://codeforces.com/contest/152/problem/B


import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long yardSizeX = input.nextInt();
        long yardSizeY = input.nextInt();
        Point currentPosition = new Point();
        currentPosition.x = input.nextInt();
        currentPosition.y = input.nextInt();
        long numberOfVectors = input.nextInt();
        Point vector = new Point();
        long steps = 0;
        long distanceX;
        long distanceY;
        long distance;
        for (int i = 0; i < numberOfVectors; i++) {
            vector.x = input.nextInt();
            vector.y = input.nextInt();
            if (vector.x > 0) {
                distanceX = (yardSizeX - currentPosition.x) / vector.x;
            } else if (vector.x < 0) {
                distanceX = (currentPosition.x - 1) / -vector.x;
            } else {
                distanceX = Integer.MAX_VALUE;
            }

            if (vector.y > 0) {
                distanceY = (yardSizeY - currentPosition.y) / vector.y;
            } else if (vector.y < 0) {
                distanceY = (currentPosition.y - 1) / -vector.y;
            } else {
                distanceY = Integer.MAX_VALUE;
            }

            distance = Math.min(distanceX, distanceY);
            currentPosition.translate((int) (distance * vector.x), (int) (distance * vector.y));
            steps += distance;

        }

        System.out.println(steps);
    }
}
