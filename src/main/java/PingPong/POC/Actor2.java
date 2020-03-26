package PingPong.POC;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Actor2 extends AbstractActor {

    public static Props props(){
        return Props.create(Actor2.class);
    }

    private ActorRef actor1 = getContext().actorOf(Ator1.props(), "actor1");

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(MailBox.mailBox1.class,this::ler)
                .match(MailBox.mailBox2.class,this::reenviando)
                .build();
    }

    private void ler(MailBox.mailBox1 t){

        log.info("Lendo Mensagem: {}",t.tomadora());
    }
    private void reenviando(MailBox.mailBox2 t){
        log.info(t + "ENVIANDO");
        actor1.tell(t.tomadora(),getSelf());
    }
}
