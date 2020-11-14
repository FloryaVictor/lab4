package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import java.util.Map;
import lab4.Messages.*;

public class StorageActor extends AbstractActor {
    private Map<String, String> testResultsById;


    @Override
    public Receive createReceive() {

        return ReceiveBuilder.create()
                .match(TestResultMsg.class, result -> {

                })
                .match(GetTestResultMsg.class, req -> {
                    req.
                })
                .build();
    }
}
