package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.Map;

public class StorageActor extends AbstractActor {
    private Map<String, String> testResultsById;

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match()
                .match()
                .build();
    }
}
