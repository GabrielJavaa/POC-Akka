package PingPong.POC.pong;


import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("SupervisorPong")
@Scope("prototype")
public class SupervisorPong extends UntypedActor {

   ActorRef actorPong1, actorPong2 ,actorPong3;

   public static Props props(){
       return Props.create(SupervisorPong.class);
   }

    @Override
    public void preStart() throws Exception {
        super.preStart();

        actorPong1 = getContext().actorOf(ActorPong.props(),"ActorPong1");
        actorPong2 = getContext().actorOf(ActorPong.props(),"ActorPong2");
        actorPong3 = getContext().actorOf(ActorPong.props(),"ActorPong3");
    }


    @Override
    public void onReceive(Object message) throws Throwable {
            if (message instanceof BuffProto.MensagemPing1){
                actorPong1.tell(message, getSelf());
            }else if (message instanceof BuffProto.MensagemPong1){
                actorPong1.tell(message, getSelf());
            } if (message instanceof BuffProto.MensagemPing2){
                actorPong2.tell(message, getSelf());
            }else if (message instanceof BuffProto.MensagemPong2){
                actorPong2.tell(message, getSelf());
            } if (message instanceof BuffProto.MensagemPing3){
                actorPong3.tell(message, getSelf());
            }else if (message instanceof BuffProto.MensagemPong3){
                actorPong3.tell(message, getSelf());
            }
    }
}
