package lab4.Actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import lab4.Messages.*;


public class StorageActor extends AbstractActor {
    private final HashMap<String, ArrayList<String>> testResultsById = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(TestResultMsg.class, result -> {
                    if (!testResultsById.containsKey(result.getTestId()))
                    {
                        testResultsById.put(result.getTestId(), new ArrayList<>());
                    }
                    testResultsById.get(result.getTestId()).add(result.getTestResult());
                })
                .match(GetTestResultMsg.class, req -> {
                    String id = req.getTestId();
                    ArrayList<String> results = testResultsById.getOrDefault(id, null);
                    SomeTestResultsMsg resp = new SomeTestResultsMsg(id, results);
                    sender().tell(resp, ActorRef.noSender());
                })
                .build();
    }
}
