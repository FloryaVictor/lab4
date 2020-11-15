package lab4.Messages;

import lab4.TestData;

public class RunTestMsg {
    private final TestData testData;

    public RunTestMsg(TestData testData){
        this.testData = new TestData(testData);
    }

    public TestData getTestData() {
        return testData;
    }
}
