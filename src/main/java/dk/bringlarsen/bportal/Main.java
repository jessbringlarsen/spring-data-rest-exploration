package dk.bringlarsen.bportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.reactive.WebSocketReactiveAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketMessagingAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
// We are not using eg. websocket so we disable support for it.
@SpringBootApplication(exclude = {
    WebSocketMessagingAutoConfiguration.class,
    WebSocketServletAutoConfiguration.class,
    WebSocketReactiveAutoConfiguration.class,
    JmxAutoConfiguration.class})
public class Main {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
