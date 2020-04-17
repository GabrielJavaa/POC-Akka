package PingPong.POC.ping;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

public class SpringActorProducer implements IndirectActorProducer {

    final private ApplicationContext applicationContext;
    final private String actorBean;

    public SpringActorProducer(ApplicationContext applicationContext, String actorBean) {
        this.applicationContext = applicationContext;
        this.actorBean = actorBean;
    }

    @Override
    public Actor produce() {
        return (Actor) applicationContext.getBean(actorBean);
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>)applicationContext.getType(actorBean);
    }
}
