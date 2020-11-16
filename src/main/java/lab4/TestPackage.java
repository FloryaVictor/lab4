package lab4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

public class TestPackage {
    private final String ID = "id";
    private final String CODE = "code";
    private final String FUNCTION_NAME = "funcName";
    private final String TESTS = "tests";

    @JsonValue("id")
    public String id;


    @JsonCreator
    public TestPackage(@JsonProperty(ID) String id){
    }
}
