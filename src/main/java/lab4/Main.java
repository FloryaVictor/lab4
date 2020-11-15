package lab4;

import akka.NotUsed;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;


import akka.routing.RouterActor;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import akka.util.Timeout;
import lab4.Messages.GetTestResultsMsg;
import lab4.Messages.RunTestMsg;
import scala.concurrent.Future;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.CompletionStage;

import static akka.http.javadsl.server.Directives.*;
import static akka.pattern.Patterns.ask;

public class Main {
    private final static Timeout timeout = Timeout.create(Duration.ofSeconds(5));

    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create("routes");
        final Http http = Http.get(system);
        ActorRef routerActor = system.actorOf(Props.create(RouterActor.class));
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                createRoute(system, routerActor).flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost("localhost", 8080),
                materializer
        );
        System.out.println("Server online at http://localhost:8080/\nPress RETURN to stop...");
        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());


    }

    public static Route createRoute(ActorSystem system, ActorRef routerActor) {
        return concat(
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