package lab4;

import java.util.ArrayList;

public class TestPackage {
    private final String id;
    private final String code;
    private final String funcName;
    private final ArrayList<OneTest> tests;
    public  TestPackage(String id, String code, String funcName){
        this.id = id;
        this.code = code;
        this.funcName = funcName;
    }
}
