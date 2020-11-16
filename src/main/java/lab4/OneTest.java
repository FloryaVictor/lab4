package lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OneTest {
    private final String TEST_NAME = "testName";
    private final String EXPECTED_RESULT = "expectedResult";
    

    @JsonProperty
    public final String testName;
    public final String expectedResult;
    public final String params;
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
