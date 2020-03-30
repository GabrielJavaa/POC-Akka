package PingPong.POC;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.io.Serializable;

public class Ator1 extends UntypedAbstractActor implements Serializable {


    public static Props props() {
        return Props.create(Ator1.class);
    }

    private String path = "akka.tcp://ActorSystemPong@127.0.0.1:2553/user/Actor2";

    private ActorSelection selection = getContext().actorSelection(path);

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof MailBox.mailBox1) {
            log.info("iniciando");
            selection.tell(new MailBox.mailBox1("Ping"), getSelf());
        }else if(message instanceof  MailBox.mailBox2){
            log.info("recebendo" + ((MailBox.mailBox2) message).getPong());
        }
    }

}
