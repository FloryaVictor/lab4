package lab4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class TestPackage {
    private final String ID = "packageId";
    private final String CODE = "jsScript";
    private final String FUNCTION_NAME = "functionName";
    private final String TESTS = "tests";

    @JsonProperty(ID)
    public final String id;

    @JsonProperty(CODE)
    public final String code;

    @JsonProperty(FUNCTION_NAME)
    public final String funcName;

    @JsonProperty(TESTS)
    public final ArrayList<OneTest> tests;

    @JsonCreator
    public TestPackage(@JsonProperty(ID) String id, @JsonProperty(CODE) String code,
                       @JsonProperty(FUNCTION_NAME) String funcName, @JsonProperty(TESTS) ArrayList<OneTest> tests){
        this.id = id;
        this.code = code;
        this.funcName = funcName;
        this.tests = tests;
    }
}
