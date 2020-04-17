package PingPong.POC.pong;

import PingPong.POC.pong.SpringExtension;
import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigurationPong {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpringExtension springExtensionPong;

    @Bean
    public ActorSystem actorSystemPong(){
        ActorSystem system = ActorSystem.create("ActorSystemPong", akkaConfig());
        springExtensionPong.initialize(applicationContext);
        return system;
    }
    @Bean
    public Config akkaConfig(){
        return ConfigFactory.load().getConfig("ActorSystemPong");
    }
}
