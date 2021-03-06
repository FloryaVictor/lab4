package lab4.Actors;


import akka.dispatch.OnComplete;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;
import akka.util.Timeout;
import static akka.pattern.Patterns.ask;

import scala.concurrent.Future;

import java.time.Duration;

import lab4.Messages.*;





public class RouterActor extends AbstractActor {
    private final int NUM_OF_RUNNERS = 5;

    private final ActorRef testRunnersPool = getContext().actorOf(
            new RoundRobinPool(NUM_OF_RUNNERS)
                    .props(Props.create(TestRunnerActor.class)));
    private final ActorRef storageActor = getContext().actorOf(Props.create(StorageActor.class));
    private final Timeout timeout = Timeout.create(Duration.ofSeconds(5));

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(RunTestMsg.class, test->{
                    Future<Object> f = ask(testRunnersPool, test, timeout);
                    f.onComplete(new OnComplete<Object>() {
                        public void onComplete(Throwable t, Object result)
                        {
                            TestResultMsg msg = (TestResultMsg)result;
                            storageActor.tell(msg, self());
                        }
                    }, getContext().getDispatcher());
                })
                .match(GetTestResultsMsg.class, req -> {
                    Future<Object> f = ask(storageActor, req, timeout);
                    ActorRef sender = getSender();
                    f.onComplete(new OnComplete<Object>() {
                        public void onComplete(Throwable t, Object result)
                        {
                            SomeTestResultsMsg msg = (SomeTestResultsMsg)result;
                            sender.tell(msg.getTestResults(), self());
                        }
                    }, getContext().getDispatcher());
                }).build();
    }
}
