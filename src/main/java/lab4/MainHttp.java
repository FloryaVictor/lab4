package lab4;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;

import akka.http.javadsl.server.Route;
import static akka.http.javadsl.server.Directives.*;
import java.util.concurrent.CompletionStage;

public class MainHttp {
    private final ActorSystem system;
    private final ActorRef routerActor;
    public MainHttp(ActorSystem system)
    {
        this.system = system;
        this.routerActor = system.actorOf()
    }

//    public Route createRoute(ActorSystem system) {
//
//    }
}
