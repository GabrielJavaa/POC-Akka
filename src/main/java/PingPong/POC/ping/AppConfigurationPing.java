package PingPong.POC.ping;

import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class AppConfigurationPing {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpringExtension springExtension;

    @Bean
    public ActorSystem actorSystemPing(){
        ActorSystem system = ActorSystem.create("ActorSystemPing", akkaConfig());
        springExtension.initialize(applicationContext);
        return system;
    }
    @Bean
    public Config akkaConfig(){
        return ConfigFactory.load().getConfig("ActorSystemPing");
    }

}
