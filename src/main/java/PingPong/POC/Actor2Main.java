package PingPong.POC;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class Actor2Main {

    public static void main (String[] args) {
        ActorSystem system = ActorSystem.create("actor_system");
        ActorRef actor2 = system.actorOf(Actor2.props(),"actor2");

        actor2.tell(new MailBox.mailBox2("pong"),ActorRef.noSender());
    }
}
