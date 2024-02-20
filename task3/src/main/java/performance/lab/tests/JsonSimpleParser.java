package performance.lab.tests;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonSimpleParser {
    public Values parseValue(String fileName) {
        Values values = new Values();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(fileName)) {

            JSONObject valuesJsonObject = (JSONObject) parser.parse(reader);

            JSONArray valueJsonArray = (JSONArray) valuesJsonObject.get("values");

            List<Value> valueList = new ArrayList<>();
            parseValues(valueJsonArray, valueList);

            values.setValue(valueList);

        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }

        return values;
    }

    private void parseValues(JSONArray jsonArray, List<Value> valueList) {
        for (Object valueObject : jsonArray) {
            JSONObject valueJsonObject = (JSONObject) valueObject;

            long id = (Long) valueJsonObject.get("id");
            String value = (String) valueJsonObject.get("value");

            Value valueObj = new Value((int) id, value);
            valueList.add(valueObj);

            if (valueJsonObject.containsKey("values")) {
                JSONArray subValues = (JSONArray) valueJsonObject.get("values");
                parseValues(subValues, valueList);
            }
        }
    }

    public Tests parseTest(String fileName) {
        Tests tests = new Tests();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(fileName)) {
            JSONObject testsJsonObject = (JSONObject) parser.parse(reader);

            JSONArray testJsonArray =  (JSONArray) testsJsonObject.get("tests");

            List<Test> testList = new ArrayList<>();
            for (Object testObject : testJsonArray) {
                JSONObject testJsonObject = (JSONObject) testObject;

                long id = (Long) testJsonObject.get("id");
                String title = (String) testJsonObject.get("title");
                String value = (String)  testJsonObject.get("value");
                List<Test> subTests = new ArrayList<>();
                if (testJsonObject.containsKey("values")) {
                    JSONArray subTestsArray = (JSONArray) testJsonObject.get("values");
                    parseTests(subTestsArray, subTests);
                }

                Test testObj = new Test((int) id, title, value);
                testObj.setSubTests(subTests);
                testList.add(testObj);

            }

            tests.setTest(testList);

        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }

        return tests;
    }

    private void parseTests(JSONArray jsonArray, List<Test> testList) {
        for (Object testObject : jsonArray) {
            JSONObject testJsonObject = (JSONObject) testObject;

            long id = (Long) testJsonObject.get("id");
            String title = (String) testJsonObject.get("title");
            String value = (String)  testJsonObject.get("value");
            List<Test> subTests = new ArrayList<>();
            if (testJsonObject.containsKey("values")) {
                JSONArray subTestsArray = (JSONArray) testJsonObject.get("values");
                parseTests(subTestsArray, subTests);
            }

            Test testObj = new Test((int) id, title, value);
            testObj.setSubTests(subTests);
            testList.add(testObj);
        }
    }

    public Object mergeObjects(Tests tests, Values values) {
        for (Test test : tests.getTest()) {
            for (Value value : values.getValue()) {
                if (test.getId() == value.getId()) {
                    test.setValue(value.getValue());
                }
                if (!test.getSubTests().isEmpty()) {
                    mergeSubTests(test.getSubTests(), values);
                }
            }
        }

        return tests;
    }

    private void mergeSubTests(List<Test> subTests, Values values) {
        for (Test subTest : subTests) {
            for (Value value : values.getValue()) {
                if (subTest.getId() == value.getId()) {
                    subTest.setValue(value.getValue());
                }
                if (!subTest.getSubTests().isEmpty()) {
                    mergeSubTests(subTest.getSubTests(), values);
                }
            }
        }
    }
}