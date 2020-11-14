package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;
import java.util.HashMap;
import lab4.Messages.*;

public class StorageActor extends AbstractActor {
    private final HashMap<String, String> testResultById = new HashMap<>();
    
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestResultMsg.class, result -> {
                    testResultById.put(result.getTestId(), result.getTestResult());
                })
                .match(GetTestResultMsg.class, req -> {
                    String id = req.getTestId();
                    sender().tell(new TestResultMsg(id, testResultById.get(id)), ActorRef.noSender());
                })
                .build();
    }
}
