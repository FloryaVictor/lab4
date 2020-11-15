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
                .match(GetTestResultsMsg.class, req -> {
                    String id = req.getTestId();
                    //
                    ArrayList<String> a= new ArrayList<>();
                    a.add("lol");
                    //
                    ArrayList<String> results = testResultsById.getOrDefault(id, a);
                    //
                    SomeTestResultsMsg resp = new SomeTestResultsMsg(id, results);
                    getSender().tell(resp, self());
                })
                .build();
    }
}
