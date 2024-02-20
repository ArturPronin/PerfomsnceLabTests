package performance.lab.tests;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private int id;
    private String title, value;
    private List<Test> subTests;
    final char dm = (char) 34;
    public Test(int id, String title, String value) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.subTests = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Test> getSubTests() {
        return subTests;
    }

    public void setSubTests(List<Test> subTests) {
        this.subTests = subTests;
    }

    public void addSubTest(Test subTest) {
        if (subTest != null) {
            this.subTests.add(subTest);
        }
    }

    @Override
    public String toString() {
        return "{" + dm +
                "id" +dm + ": " + id +
                "," + dm + "title" + dm + ": " + dm +  title +  dm +
                "," + dm + "value" + dm + ": " + dm + value +  dm +
                ((subTests.isEmpty()) ? "" : ("," + dm + "values" + dm + ": " + subTests)) +
                '}';
    }
}