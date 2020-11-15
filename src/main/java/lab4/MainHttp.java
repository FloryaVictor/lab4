package lab4;

import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;

import akka.http.javadsl.server.Route;
import static akka.http.javadsl.server.Directives.*;
import java.util.concurrent.CompletionStage;

public class MainHttp {
    private final ActorSystem system;
    public MainHttp(ActorSystem system)
    {
        this.system = system;
    }

    public Route createRoute(ActorSystem system) {

    }
}
