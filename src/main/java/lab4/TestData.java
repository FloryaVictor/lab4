package lab4;

import java.util.ArrayList;
import org.json.*;

public class TestData {
    private final String id;
    private final String code;
    private final String funcName;
    private final String testName;
    private final String expectedValue;
    private final String params;
    public TestData(String id, String code, String funcName, String testName, String expectedValue, String params){
        this.id = id;
        this.code = code;
        this.funcName = funcName;
        this.testName = testName;
        this.expectedValue = expectedValue;
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getFuncName() {
        return funcName;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public String getParams() {
        return params;
    }

    public static ArrayList<TestData> fromJSON(String json){
        ArrayList<TestData> parsedTests = new ArrayList<>();
        JSONObject data = new JSONObject(json);
        String id = data.getString("packageId");
        String code = data.getString("jsScript");
        String funcName = data.getString("functionName");
        String[] tests = CDL.toString(data.getJSONArray("tests")).split(",");
        for(String test : tests){
            JSONObject testData = 
        }
        return parsedTests;
    }
}
