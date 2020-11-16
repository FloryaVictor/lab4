package lab4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonRawValue;

public class TestPackage {
    @JsonRawValue
    public String json;

    @JsonCreator
    public TestPackage(){
        
    }
}
