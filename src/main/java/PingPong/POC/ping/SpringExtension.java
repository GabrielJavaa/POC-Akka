package PingPong.POC.ping;

import PingPong.POC.pong.SpringActorProducer;
import akka.actor.Extension;
import akka.actor.Props;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringExtension implements Extension {

    private ApplicationContext applicationContext;

    public void initialize(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    public Props props(String beanName){
        return Props.create(SpringActorProducer.class, applicationContext, beanName);
    }
}
