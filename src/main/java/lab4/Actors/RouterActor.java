package lab4.Actors;

import akka.actor.AbstractActor;
import akka.actor.Actor;
import akka.actor.ActorRef;

import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;
import lab4.Actors.*;
import lab4.Messages.*;

public class RouterActor extends AbstractActor {
    private final ActorRef testRunnersPool = getContext().actorOf(
            new RoundRobinPool(5)
                .props(Props.create(TestRunnerActor.class))
    );

    private final ActorRef storageActor = getContext().actorOf(
            Props.create(StorageActor.class)
    );

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(RunTestMsg.class, test->{

                })
                .match(GetTestResultMsg).build();
    }
}
