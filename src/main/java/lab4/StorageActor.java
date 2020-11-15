package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import lab4.Messages.*;


public class StorageActor extends AbstractActor {
    private final HashMap<String, ArrayList<String>> testResultById = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestResultMsg.class, result -> {
                    if (!testResultById.containsKey(result.getTestId()))
                    {
                        testResultById.put(result.getTestId(), new ArrayList<>());
                    }
                    testResultById.get(result.getTestId()).add(result.getTestResult());
                })
                .match(GetTestResultMsg.class, req -> {
                    String id = req.getTestId();
                    sender().tell(new SomeTestResultsMsg(testResultById.get(id)), ActorRef.noSender());
                })
                .build();
    }
}
