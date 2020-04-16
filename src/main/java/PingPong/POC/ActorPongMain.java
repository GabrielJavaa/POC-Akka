package PingPong.POC;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.typesafe.config.ConfigFactory;


public class ActorPongMain {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("ActorSystemPong", ConfigFactory.load().getConfig("ActorSystemPong"));
        ActorRef supervisorPong = system.actorOf(SupervisorPong.props(), "SupervisorPong");

        supervisorPong.tell(new MailBox.mensagemPong1(),null);
        supervisorPong.tell(new MailBox.mensagemPong2(),null);
        supervisorPong.tell(new MailBox.mensagemPong3(),null);
    }
}
