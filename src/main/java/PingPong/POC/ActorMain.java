package PingPong.POC;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.typesafe.config.ConfigFactory;


public class ActorMain {


    public static void main(String[] args) {


        ActorSystem system = ActorSystem.create("ActorSystemPing", ConfigFactory.load().getConfig("ActorSystemPing"));
        ActorRef actor = system.actorOf(Ator1.props(), "Actor1");

        actor.tell(new MailBox.mailBox1("ping"), null);

    }
}
