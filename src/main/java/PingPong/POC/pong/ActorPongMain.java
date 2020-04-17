package PingPong.POC.pong;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class ActorPongMain implements CommandLineRunner {

    @Autowired
    private ActorSystem actorSystemPong;

    @Autowired
    private SpringExtension springExtension;


    public static void main(String[] args) {
        SpringApplication.run(ActorPongMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        BuffProto.MensagemPong1 messagePong1 = BuffProto.MensagemPong1.newBuilder().setMensagemPong1("pong1").build();
        BuffProto.MensagemPong2 messagePong2 = BuffProto.MensagemPong2.newBuilder().setMensagemPong2("pong2").build();
        BuffProto.MensagemPong3 messagePong3 = BuffProto.MensagemPong3.newBuilder().setMensagemPong3("pong3").build();

        ActorRef supervisorPong = actorSystemPong.actorOf(springExtension.props("SupervisorPong"), "SupervisorPong");

        supervisorPong.tell(messagePong1,null);
        supervisorPong.tell(messagePong2,null);
        supervisorPong.tell(messagePong3,null);
    }
}
