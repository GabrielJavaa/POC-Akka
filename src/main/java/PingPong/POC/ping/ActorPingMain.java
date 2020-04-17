package PingPong.POC.ping;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
 public class ActorPingMain implements CommandLineRunner {

    @Autowired
    private ActorSystem actorSystemPing;

    @Autowired
    private SpringExtension springExtension;


    public static void main(String[] args) {
        SpringApplication.run(ActorPingMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        BuffProto.MensagemPing1 messagePing1 = BuffProto.MensagemPing1.newBuilder().setMensagemPing1("ping1").build();
        BuffProto.MensagemPing2 messagePing2 = BuffProto.MensagemPing2.newBuilder().setMensagemPing2("ping2").build();
        BuffProto.MensagemPing3 messagePing3 = BuffProto.MensagemPing3.newBuilder().setMensagemPing3("ping3").build();

        ActorRef supervisorPing = actorSystemPing.actorOf(springExtension.props("SupervisorPing"), "SupervisorPing");


        supervisorPing.tell(messagePing1 ,null);
        supervisorPing.tell(messagePing2, null);
        supervisorPing.tell(messagePing3, null);
    }


}
