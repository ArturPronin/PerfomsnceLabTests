package performance.lab.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskTwo {

    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                System.out.println("Используйте команду: java TaskTwo file1.txt file2.txt");
                return;
            }
            Scanner circleScanner = new Scanner(new File(args[0]));
            float circleX = circleScanner.nextFloat();
            float circleY = circleScanner.nextFloat();
            float radius = circleScanner.nextFloat();

            Scanner pointsScanner = new Scanner(new File(args[1]));
            while (pointsScanner.hasNextFloat()) {
                float pointX = pointsScanner.nextFloat();
                float pointY = pointsScanner.nextFloat();

                float distance = (float) Math.sqrt(Math.pow(pointX - circleX, 2) + Math.pow(pointY - circleY, 2));
                if (Float.compare(distance, radius) == 0) {
                    System.out.println(0);  // точка лежит на окружности
                } else if (distance < radius) {
                    System.out.println(1);  // точка внутри
                } else {
                    System.out.println(2);  // точка снаружи
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

}
