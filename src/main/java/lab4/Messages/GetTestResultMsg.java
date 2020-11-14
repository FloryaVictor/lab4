package lab4.Messages;

public class GetTestResultMsg {
    public final String testId;

    public GetTestResultMsg(String testId){
        this.testId = testId;
    }

    public String value(){
        return testId;
    }
}
