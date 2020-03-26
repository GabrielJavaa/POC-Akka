package PingPong.POC;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Ator1 extends AbstractActor {

    String msg = "ping";

    public static Props props() {
        return Props.create(Ator1.class);
    }



    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, this::mensagemParaPong)
                .build();
    }

    private void mensagemParaPong(String s) {
        log.info("Deu boa: {}", s);
        log.info(msg + "Dale");
        getSender().tell(new MailBox.mailBox1(msg), getSelf());
    }
}
