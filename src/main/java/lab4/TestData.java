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

    public TestData(TestData t){
        this.id = t.id;
        this.code = t.code;
        this.funcName = t.funcName;
        this.testName = t.testName;
        this.expectedResult = t.expectedResult;
        this.params = t.params;
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

    public static ArrayList<TestData> fromPackage(TestPackage testPackage){
        ArrayList<TestData> parsedTests = new ArrayList<>();
        String id = testPackage.id;
        String code = testPackage.code;
        String funcName = testPackage.funcName;
        for(OneTest t: testPackage.tests){
            parsedTests.add(new TestData(id, code, funcName, t.testName, t.expectedResult, t.params.toString()));
        }
        return parsedTests;
    }
}
