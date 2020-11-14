package lab4.Messages;

import java.util.ArrayList;

public class AllTestResultsMsg {
    private final String testId;
    private final ArrayList<String> results;

    public AllTestResultsMsg(String testId, ArrayList<String> results){
        this.testId = testId;
        
    }
}
