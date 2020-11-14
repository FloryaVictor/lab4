package lab4.Messages;

public class TestResultMsg {
    public final String testResult;

    public TestResultMsg(String testResult){
        this.testResult = testResult;
    }

    public String value(){
        return testResult;
    }
}
