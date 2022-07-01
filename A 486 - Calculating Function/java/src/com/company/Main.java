import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long x = input.nextLong();
        if (x % 2 == 0) {
            System.out.print(x / 2);
        } else {
            System.out.print(-1 * (x + 1) / 2);
        }
    }
}
