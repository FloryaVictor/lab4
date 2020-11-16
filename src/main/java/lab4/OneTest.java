package lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class OneTest {
    private final String TEST_NAME = "testName";
    private final String EXPECTED_RESULT = "expectedResult";
    private final String PARAMS = "params";


    @JsonProperty(TEST_NAME)
    public final String testName;

    @JsonProperty(EXPECTED_RESULT)
    public final String expectedResult;

    @JsonProperty(PARAMS)
    public final ArrayList<Integer> params;

    public OneTest(@JsonProperty(TEST_NAME) String testName, @JsonProperty(EXPECTED_RESULT) String expectedResult,
                   @JsonProperty(PARAMS) ArrayList<Integer> params) {
        this.testName= testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }
}
