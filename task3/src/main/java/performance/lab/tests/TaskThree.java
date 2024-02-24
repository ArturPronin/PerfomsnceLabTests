package performance.lab.tests;


import java.io.FileWriter;
import java.io.IOException;

public class TaskThree {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Используйте команду: java TaskThree tests.json values.json");
            return;
        }

        String testsFile = args[0];
        String valuesFile = args[1];

        JsonSimpleParser parser = new JsonSimpleParser();
        Values values = parser.parseValue(valuesFile);
        Tests tests = parser.parseTest(testsFile);


        FileWriter file = new FileWriter("report.json");
        file.write(parser.mergeObjects(tests, values).toString());
        file.flush();
        file.close();
        System.out.println("Файл report.json успешно создан");


    }

}
