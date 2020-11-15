package lab4.Messages;

import java.util.ArrayList;

public class SomeTestResultsMsg {
    private final String testId;
    private final ArrayList<String> testResults;

    public SomeTestResultsMsg(String testId, ArrayList<String> results){
        this.testId = testId;
        this.testResults = new ArrayList<>(results);
    }

    public String getTestId(){
        return testId;
    }

    public ArrayList<String> getTestResults(){
        ArrayList<String> copy = (ArrayList<String>) testResults.clone();
        return testResults;
    }
}
