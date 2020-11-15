package lab4.Messages;

public class GetTestResultsMsg {
    private final String testId;

    public GetTestResultsMsg(String testId){
        this.testId = testId;
    }

    public String getTestId(){
        return testId;
    }
}
