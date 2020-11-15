package lab4.Actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import akka.routing.RoundRobinPool;
import lab4.Actors.*;
import lab4.Messages.*;

public class RouterActor extends AbstractActor {
    private final ActorRef testActorsPool = getContext().actorOf(
            new RoundRobinPool(4)
    );

    @Override
    public Receive createReceive() {
        return null;
    }
}
