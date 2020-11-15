package lab4.Messages;

public class RunTestMsg {
    private final String testId;
    private final String testCode;
    private final String testData;

    public RunTestMsg(String testId, String testCode, String testData){
        this.testId = testId;
        this.testCode = testCode;
        this.testData = testData;
    }

    public String getTestId() {
        return testId;
    }

    public String getTestCode() {
        return testCode;
    }

    public String getTestData() {
        return testData;
    }
}
