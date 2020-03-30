package PingPong.POC;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.typesafe.config.ConfigFactory;


public class Actor2Main {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("ActorSystemPong", ConfigFactory.load().getConfig("ActorSystemPong"));
        ActorRef ator2 = system.actorOf(Actor2.props(), "Actor2");
    }
}
