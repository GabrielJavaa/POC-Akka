package PingPong.POC;

import akka.actor.ActorSelection;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.io.Serializable;

@Actor
public class AtorPing extends UntypedAbstractActor implements Serializable {


    public static Props props() {
        return Props.create(AtorPing.class);
    }

    private String path = "akka.tcp://ActorSystemPong@127.0.0.1:2553/user/SupervisorPong";
    private ActorSelection selection = getContext().actorSelection(path);

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);


    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof MailBox.mensagemPing1) {
            log.info("iniciando: ");
            selection.tell(new MailBox.mensagemPing1("Ping"), getSelf());
        } else if (message instanceof MailBox.mensagemPong1) {
            log.info("recebendo: " + ((MailBox.mensagemPong1) message).getPong());


        }if (message instanceof MailBox.mensagemPing2) {
            log.info("iniciando: " );
            selection.tell(new MailBox.mensagemPing2("Ping"), getSelf());
        } else if (message instanceof MailBox.mensagemPong2) {
            log.info("recebendo: " + ((MailBox.mensagemPong2) message).getPong());


        }if (message instanceof MailBox.mensagemPing3) {
            log.info("iniciando: " );
            selection.tell(new MailBox.mensagemPing3("Ping"), getSelf());
        } else if (message instanceof MailBox.mensagemPong3) {
            log.info("recebendo: " + ((MailBox.mensagemPong3) message).getPong());
        }
    }

}
