package lab4;

import java.util.ArrayList;
import org.json.*;

public class TestData {
    private final String id;
    private final String code;
    private final String funcName;
    private final String testName;
    private final String expectedResult;
    private final String params;
    public TestData(String id, String code, String funcName, String testName, String expectedResult, String params){
        this.id = id;
        this.code = code;
        this.funcName = funcName;
        this.testName = testName;
        this.expectedResult = expectedResult;
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

    public String getExpectedResult() {
        return expectedResult;
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



        JSONArray tests = data.getJSONArray("tests");
        for(int i = 0; i < tests.length(); i++){

            JSONObject testData = tests.getJSONObject(i);
            parsedTests.add(new TestData(id, code, funcName,
                                        testData.getString("testName"),
                                        testData.getString("expectedResult"),
                                        testData.getJSONArray("params").toString()));
        }
        return parsedTests;
    }
}
