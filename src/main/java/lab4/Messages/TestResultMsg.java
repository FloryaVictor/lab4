package lab4.Messages;

public class TestResultMsg {
    public final String testId;
    public final String testResult;

    public TestResultMsg(String testId, String testResult){
        this.testId = testId;
        this.testResult = testResult;
    }

    public String getTestId(){
        return testId;
    }

    public String getTestResult(){
        return testResult;
    }

}
