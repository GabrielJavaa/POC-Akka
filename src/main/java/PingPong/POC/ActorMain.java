package PingPong.POC;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class ActorMain {


    public static void main (String[] args){


        ActorSystem system = ActorSystem.create("Actor1");
        ActorRef actor1 = system.actorOf(Ator1.props(),"actor1");

        actor1.tell(new MailBox.mailBox1("ping"),ActorRef.noSender());
    }
}
