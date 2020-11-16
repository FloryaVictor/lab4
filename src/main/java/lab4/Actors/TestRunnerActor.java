package lab4.Actors;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import lab4.Messages.RunTestMsg;
import lab4.Messages.TestResultMsg;
import lab4.TestData;

public class TestRunnerActor extends AbstractActor {
    private final static String JS_COMPILER = "nashorn";

    public static String runJS(TestData testData) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(JS_COMPILER);
        engine.eval(testData.getCode());
        Invocable invocable = (Invocable) engine;
        String answ = invocable.invokeFunction(testData.getFuncName(), testData.getParams()).toString();
        System.out.println(answ);

        if (!answ.equals(testData.getExpectedResult()))
        {
            return "Test " +
                    testData.getTestName() +
                    " from package with id " +
                    testData.getId() +
                    " has failed: expected result is " +
                    testData.getExpectedResult() +
                    " but actual is " +
                    answ;
        }
        return "Test " +
                testData.getTestName() +
                " from package with id " +
                testData.getId() +
                " has succeeded";
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(RunTestMsg.class, req -> {
                    TestData testData = req.getTestData();
                    getSender().tell(new TestResultMsg(testData.getId(), runJS(testData)), self());
                }).build();
    }
}
