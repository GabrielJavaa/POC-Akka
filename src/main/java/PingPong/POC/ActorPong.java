package PingPong.POC;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;


import java.io.Serializable;

public class ActorPong extends UntypedAbstractActor implements Serializable {


    public static Props props(){
        return Props.create(ActorPong.class);
    }


    private String path = "akka.tcp://ActorSystemPing@127.0.0.1:2552/user/SupervisorPing";

    private ActorSelection selection = getContext().actorSelection(path);


    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);


    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof MailBox.mensagemPing1){
            log.info("recebendo: " + ((MailBox.mensagemPing1) message).getPing());

            selection.tell(new MailBox.mensagemPong1("Pong1"), getSelf());


        }if (message instanceof MailBox.mensagemPing2){
            log.info("recebendo: " + ((MailBox.mensagemPing2) message).getPing());

            selection.tell(new MailBox.mensagemPong2("Pong2"), getSelf());


        }if (message instanceof MailBox.mensagemPing3){
            log.info("recebendo: " + ((MailBox.mensagemPing3) message).getPing());

            selection.tell(new MailBox.mensagemPong3("Pong3"), getSelf());
        }
    }

}
