package PingPong.POC.ping;

import akka.actor.ActorSelection;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.io.Serializable;


public class AtorPing extends UntypedAbstractActor implements Serializable {


    public static Props props() {
        return Props.create(AtorPing.class);
    }

    private String path = "akka.tcp://ActorSystemPong@127.0.0.1:2553/user/SupervisorPong";
    private ActorSelection selection = getContext().actorSelection(path);

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);


    BuffProto.MensagemPing1 messagePing1 = BuffProto.MensagemPing1.newBuilder().setMensagemPing1("ping1").build();
    BuffProto.MensagemPing2 messagePing2 = BuffProto.MensagemPing2.newBuilder().setMensagemPing2("ping2").build();
    BuffProto.MensagemPing3 messagePing3 = BuffProto.MensagemPing3.newBuilder().setMensagemPing3("ping3").build();

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof BuffProto.MensagemPing1) {
            log.info("iniciando: ");
            selection.tell(messagePing1, getSelf());
        } else if (message instanceof BuffProto.MensagemPong1) {
            log.info("recebendo: " + ((BuffProto.MensagemPong1) message).getMensagemPong1());


        }if (message instanceof BuffProto.MensagemPing2) {
            log.info("iniciando: " );
            selection.tell(messagePing2, getSelf());
        } else if (message instanceof BuffProto.MensagemPong2) {
            log.info("recebendo: " + ((BuffProto.MensagemPong2) message).getMensagemPong2());


        }if (message instanceof BuffProto.MensagemPing3) {
            log.info("iniciando: " );
            selection.tell(messagePing3, getSelf());
        } else if (message instanceof BuffProto.MensagemPong3) {
            log.info("recebendo: " + ((BuffProto.MensagemPong3) message).getMensagemPong3());
        }
    }

}
