package lab4.Actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class RouterActor extends AbstractActor {
    private final ActorRef testActorsPool = getContext();

    @Override
    public Receive createReceive() {
        return null;
    }
}
