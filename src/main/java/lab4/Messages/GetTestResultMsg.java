package lab4.Messages;

public class GetTestResultMsg {
    private final String testId;

    public GetTestResultMsg(String testId){
        this.testId = testId;
    }

    public String getTestId(){
        return testId;
    }
}
