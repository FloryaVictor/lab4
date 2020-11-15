package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;
import lab4.Messages.RunTestMsg;
import lab4.Messages.TestResultMsg;

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
                    String res = invocable.invokeFunction(req.getTestFunctionName(), req.getTestData()).toString();
                    sender().tell(new TestResultMsg(req.getTestId(), res), ActorRef.noSender());
                }).build();
    }
}