package lab4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

public class TestPackage {
    @JsonValue
    public String json;


    @JsonCreator
    public TestPackage(@JsonProperty()){

    }
}
