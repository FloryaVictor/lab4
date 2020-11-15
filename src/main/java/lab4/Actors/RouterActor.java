package lab4.Actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import lab4.Actors.*;
import lab4.Messages.*;

public class RouterActor extends AbstractActor {
    private final ActorRef testActorsPool = getContext().actorOf(
            
    );

    @Override
    public Receive createReceive() {
        return null;
    }
}
