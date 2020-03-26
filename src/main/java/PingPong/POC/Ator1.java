package PingPong.POC;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Ator1 extends AbstractActor {

    String msg = "ping";

    public static Props props() {
        return Props.create(Ator1.class);
    }

    private ActorRef actor2 = getContext().actorOf(Actor2.props(),"actor2");

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, this::mensagemParaPong)
                .match(MailBox.mailBox2.class, this::recebido)
                .build();
    }

    private void mensagemParaPong(String s) {
        log.info("Deu boa: {}", s);
        log.info(msg + " dale");
        getSender().tell(new MailBox.mailBox1(msg), getSelf());
    }
    private void recebido(MailBox.mailBox2 t){
        log.info("recebendo: {}",t.tomadora());


    }
}
