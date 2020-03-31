package PingPong.POC;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;


import java.io.Serializable;

public class Actor2 extends UntypedAbstractActor implements Serializable {


    public static Props props(){
        return Props.create(Actor2.class);
    }


    private String path = "akka.tcp://AkkaRemoteServer@127.0.0.1:2552/user/Actor1";
//
    private ActorSelection selection = getContext().actorSelection(path);


    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(),this);


    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof MailBox.mailBox1){
            log.info("recebendo" + ((MailBox.mailBox1) message).getPing());

                getSender().tell(new MailBox.mailBox2("pong"),getSelf());

            selection.tell(new MailBox.mailBox2("Pong"), getSelf());
        }
    }

}
