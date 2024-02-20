package performance.lab.tests;

import java.util.List;

public class Values {
    private List<Value> value;


    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Values{" +
                "value=" + value +
                '}';
    }

}
