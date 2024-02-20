package performance.lab.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TaskFour {

    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Используйте команду: java TaskFour fileName.txt");
                return;
            }
            Scanner scanner = new Scanner(new File(args[0]));
            ArrayList<Integer> nums = new ArrayList<>();

            while (scanner.hasNextInt()) {
                nums.add(scanner.nextInt());
            }

            int minSteps = 0;
            Collections.sort(nums);
            int median = nums.get(nums.size() / 2);

            for (int num : nums) {
                minSteps += Math.abs(num - median);
            }

            System.out.println(minSteps);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

}
