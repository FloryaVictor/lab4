package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import lab4.Messages.RunTestMsg;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestRunnerActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(RunTestMsg.class, req -> {
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                    engine.eval(req.getTestCode());
                    Invocable invocable = (Invocable) engine;
                    return invocable.invokeFunction(req.getTestFunctionName(), req.getTestData()).toString();
                }).build();
    }
}
