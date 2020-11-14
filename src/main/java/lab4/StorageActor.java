package lab4;

import akka.actor.AbstractActor;
import java.util.Map;

public class StorageActor extends AbstractActor {
    private Map<String, String> testResultsBy;

    @Override
    public Receive createReceive() {
        return null;
    }
}
