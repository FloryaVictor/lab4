package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
//        ActorSystem system = ActorSystem.create("lab4");
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        ArrayList<Integer> b = a;
        a.add(4);
        System.out.println(b.size());
    }
}
