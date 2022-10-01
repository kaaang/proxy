package hello.proxy.config;

import hello.proxy.app.v1.*;
import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {

    @Bean
    public OrderControllerV2 orderController(){
        return new OrderControllerV2(orderService());
    }

    private OrderServiceV2 orderService() {
        return new OrderServiceV2(orderRepository());
    }

    private OrderRepositoryV2 orderRepository() {
        return new OrderRepositoryV2();
    }
}
