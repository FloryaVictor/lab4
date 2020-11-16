package lab4;

public class OneTest {
    private final String testName;
    private final String expectedResult;
    private final String params;
    public OneTest(String testName, String expectedResult, String params) {
        this.testName= testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getParams() {
        return params;
    }
}
