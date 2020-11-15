package lab4.Actors;


import akka.dispatch.OnComplete;
import lab4.Messages.*;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;
import akka.util.Timeout;
import scala.concurrent.Future;


import java.time.Duration;

import static akka.pattern.Patterns.ask;



public class RouterActor extends AbstractActor {
    private final ActorRef testRunnersPool = getContext().actorOf(
            new RoundRobinPool(5)
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
                    f.onComplete(new OnComplete<Object>() {
                        public void onComplete(Throwable t, Object result)
                        {
                            SomeTestResultsMsg msg = (SomeTestResultsMsg)result;
                            StringBuilder testResults = new StringBuilder();
                            for(String r : msg.getTestResults()){
                                testResults.append(r).append("\n");
                            }
                            getSender().tell(testResults.toString(), self());
                        }
                    }, getContext().getDispatcher());
                }).build();
    }
}
