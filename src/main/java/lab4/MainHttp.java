package lab4;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.server.Route;
import akka.routing.RouterActor;
import akka.util.Timeout;
import lab4.Messages.GetTestResultsMsg;
import lab4.Messages.RunTestMsg;
import scala.concurrent.Future;


import java.time.Duration;
import java.util.ArrayList;


import static akka.http.javadsl.server.Directives.*;
import static akka.pattern.Patterns.ask;

public class MainHttp {
    private final ActorSystem system;
    private final ActorRef routerActor;
    private final Timeout timeout = Timeout.create(Duration.ofSeconds(5));

    public MainHttp(ActorSystem system)
    {
        this.system = system;
        this.routerActor = system.actorOf(Props.create(RouterActor.class));
    }

    public Route createRoute() {
        return route(
                get(()->
                        parameter("packageId",(id)-> {
                            Future<String> f = ask(routerActor, new GetTestResultsMsg(id), timeout)
                                    .map(Object::toString, system.getDispatcher());
                            return completeOKWithFutureString(f);
                        })),
                post(()->
                        extractDataBytes(data -> {
                            ArrayList<TestData> testData = TestData.fromJSON(data.toString());
                            for(TestData t : testData){
                                routerActor.tell(new RunTestMsg(t), ActorRef.noSender());
                            }
                            return complete("Tests are accepted for consideration");
                        })
                )
        );

    }
}
