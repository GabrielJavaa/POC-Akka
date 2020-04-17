package PingPong.POC.ping;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("SupervisorPing")
@Scope("prototype")
public class SupervisorPing extends UntypedActor {

    ActorRef actorPing1, actorPing2, actorPing3;

    public static Props props() {
        return Props.create(SupervisorPing.class);
    }

    @Override
    public void preStart() throws Exception {
        super.preStart();

        actorPing1 = getContext().actorOf(AtorPing.props(), "ActorPing1");
        actorPing2 = getContext().actorOf(AtorPing.props(), "ActorPing2");
        actorPing3 = getContext().actorOf(AtorPing.props(), "ActorPing3");
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof BuffProto.MensagemPing1) {
            actorPing1.tell(message, getSelf());
        } else if (message instanceof BuffProto.MensagemPong1) {
            actorPing1.tell(message, getSelf());
        }
        if (message instanceof BuffProto.MensagemPing2) {
            actorPing2.tell(message, getSelf());
        } else if (message instanceof BuffProto.MensagemPong2) {
            actorPing2.tell(message, getSelf());
        }
        if (message instanceof BuffProto.MensagemPing3) {
            actorPing3.tell(message, getSelf());
        } else if (message instanceof BuffProto.MensagemPong3) {
            actorPing3.tell(message, getSelf());
        }
    }
}
