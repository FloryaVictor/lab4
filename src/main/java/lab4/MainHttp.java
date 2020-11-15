package lab4;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;

import akka.http.javadsl.server.Route;
import akka.routing.RouterActor;
import scala.concurrent.Future;

import static akka.http.javadsl.server.Directives.*;


public class MainHttp {
    private final ActorSystem system;
    private final ActorRef routerActor;
    public MainHttp(ActorSystem system)
    {
        this.system = system;
        this.routerActor = system.actorOf(Props.create(RouterActor.class));
    }

    public Route createRoute(ActorSystem system) {
        return route(
                get(()->
                        parameter("packageId",(id)->
                                {
                            Future<Object>
                            }
                        )
                )
        );

    }
}
