package PingPong.POC.pong;

import BuffProto.MensagemPong1;
import BuffProto.MensagemPong2;
import BuffProto.MensagemPong3;
import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;


import java.io.Serializable;
import java.nio.Buffer;

public class ActorPong extends UntypedAbstractActor implements Serializable {


    public static Props props(){
        return Props.create(ActorPong.class);
    }


    private String path = "akka.tcp://ActorSystemPing@127.0.0.1:2552/user/SupervisorPing";

    private ActorSelection selection = getContext().actorSelection(path);


    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);

    BuffProto.MensagemPong1 messagePong1 = BuffProto.MensagemPong1.newBuilder().setMensagemPong1("pong1").build();
    BuffProto.MensagemPong2 messagePong2 = BuffProto.MensagemPong2.newBuilder().setMensagemPong2("pong2").build();
    BuffProto.MensagemPong3 messagePong3 = BuffProto.MensagemPong3.newBuilder().setMensagemPong3("pong3").build();

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof BuffProto.MensagemPing1){
            log.info("recebendo: " + ((BuffProto.MensagemPing1) message).getMensagemPing1());

            selection.tell( messagePong1, getSelf());


        }if (message instanceof BuffProto.MensagemPing2){
            log.info("recebendo: " + ((BuffProto.MensagemPing2) message).getMensagemPing2());

            selection.tell(messagePong2, getSelf());


        }if (message instanceof BuffProto.MensagemPing3){
            log.info("recebendo: " + ((BuffProto.MensagemPing3) message).getMensagemPing3());

            selection.tell(messagePong3, getSelf());
        }
    }

}
