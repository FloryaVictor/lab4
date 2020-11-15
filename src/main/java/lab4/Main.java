package lab4;

import akka.NotUsed;

import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;


import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CompletionStage;

public class Main {
    public static void main(String[] args) {
//        ActorSystem system = ActorSystem.create("routes");
//        final Http http = Http.get(system);
//        final ActorMaterializer materializer = ActorMaterializer.create(system);
//        MainHttp instance = new MainHttp(system);
//        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
//                instance.createRoute().flow(system, materializer);
//        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
//                routeFlow,
//                ConnectHttp.toHost("localhost", 8080),
//                materializer
//        );
//        System.out.println("Server online at http://localhost:8080/\nPress ENTER to stop...");
//        Scanner scan = new Scanner(System.in);
//        scan.nextLine();
//        binding
//                .thenCompose(ServerBinding::unbind)
//                .thenAccept(unbound -> system.terminate());
//
//
        String s = "{\n" +
                "\"packageId\":\"11\",\n" +
                "\"jsScript\":\"var divideFn = function(a,b) { return a/b} \",\n" +
                "\"functionName\":\"divideFn\",\n" +
                "\"tests\": [\n" +
                "{\"testName\":\"test1\",\n" +
                "\"expectedResult\":\"2.0\",\n" +
                "\"params\":[2,1]\n" +
                "},\n" +
                "{\"testName\":\"test2\",\n" +
                "\"expectedResult\":\"2.0\",\n" +
                "\"params\":[4,2]\n" +
                "}\n" +
                "]\n" +
                "}";
        ArrayList<TestData> l = TestData.fromJSON(s);
        System.out.println(l.get(1).getTestName());
        System.out.println(l.get(1).getExpectedResult());
        System.out.println(l.get(1).getParams());
        
    }
}