package lab4.Actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;
import lab4.Messages.RunTestMsg;
import lab4.Messages.TestResultMsg;
import lab4.TestData;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestRunnerActor extends AbstractActor {
    private final static String JS_COMPILER = "nashorn";

    public static String runJS(TestData testData) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(JS_COMPILER);
        engine.eval(testData.getCode());
        Invocable invocable = (Invocable) engine;
        String invocable.invokeFunction(testData.getFuncName(), testData.getParams()).toString();
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(RunTestMsg.class, req -> {
                    TestData testData = req.getTestData();
                    getSender().tell(new TestResultMsg(testData.getId(), runJS(testData)), ActorRef.noSender());
                }).build();
    }
}
