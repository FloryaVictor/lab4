package lab4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

public class TestPackage {
    @JsonValue("id")
    public String id;


    @JsonCreator
    public TestPackage(@JsonProperty(ID) String id){
    }
}
