package PingPong.POC;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.typesafe.config.ConfigFactory;


public class ActorPingMain {


    public static void main(String[] args) {


        ActorSystem system = ActorSystem.create("ActorSystemPing", ConfigFactory.load().getConfig("ActorSystemPing"));
        ActorRef supervisorPing = system.actorOf(SupervisorPing.props(), "SupervisorPing");

        supervisorPing.tell(new MailBox.mensagemPing1(), null);
        supervisorPing.tell(new MailBox.mensagemPing2(), null);
        supervisorPing.tell(new MailBox.mensagemPing3(), null);

    }
}
