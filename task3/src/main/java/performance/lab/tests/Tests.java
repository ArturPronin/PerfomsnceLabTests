package performance.lab.tests;

import java.util.List;

public class Tests {

    private List<Test> test;
    final char dm = (char) 34;

    public List<Test> getTest() {
        return test;
    }

    public void setTest(List<Test> test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "{" + dm +
                "tests"+ dm +
                ": " + test +
                '}';
    }
}

