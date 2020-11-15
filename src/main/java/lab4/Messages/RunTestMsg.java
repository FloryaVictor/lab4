package lab4.Messages;

public class RunTestMsg {
    private final String testId;
    private final String testCode;
    private final String testData;
    private final String testFunctionName;

    public RunTestMsg(String testId, String testCode, String testData, String testFunctionName){
        this.testId = testId;
        this.testCode = testCode;
        this.testData = testData;
        this.testFunctionName = testFunctionName;
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

    public String getTestFunctionName() {
        return testFunctionName;
    }
}
