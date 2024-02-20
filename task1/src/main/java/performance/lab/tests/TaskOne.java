package performance.lab.tests;

import java.util.Scanner;

public class TaskOne {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] circleArray = new int[n];
        int currentIndex = 0;

        for (int i = 0; i < n; i++) {
            circleArray[i] = i + 1;
        }

        do {
            System.out.print(circleArray[currentIndex]);
            currentIndex = (currentIndex + m - 1) % n;
        } while (currentIndex != 0);

    }
}
