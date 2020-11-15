package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import lab4.Messages.RunTestMsg;

public class TestRunnerActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(RunTestMsg.class, req -> {
                    
                }).build();
    }
}
