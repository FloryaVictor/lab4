package lab4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;

public class TestPackage {
    private final String ID = "id";
    private final String CODE = "code";
    private final String FUNCTION_NAME = "funcName";
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
