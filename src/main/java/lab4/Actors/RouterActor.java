package lab4.Actors;

import akka.dispatch.OnSuccess;
import akka.pattern.Patterns;
import lab4.Messages.*;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;
import akka.util.Timeout;
import scala.concurrent.Future;

import java.time.Duration;


public class RouterActor extends AbstractActor {
    private final ActorRef testRunnersPool = getContext().actorOf(
            new RoundRobinPool(5)
                .props(Props.create(TestRunnerActor.class))
    );

    private final ActorRef storageActor = getContext().actorOf(
            Props.create(StorageActor.class)
    );

    private final Timeout timeout = Timeout.create(Duration.ofSeconds(1));

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(RunTestMsg.class, test->{
                    Future<Object> res = Patterns.ask(testRunnersPool, test, timeout);
                    res.onSuccess(new OnSuccess<TestResultMsg>() {
                        public void onSuc
                    });
                })
                .match(GetTestResultsMsg.class, req -> {

                })
                .match(SomeTestResultsMsg.class, resp -> {

                }).build();
    }
}
