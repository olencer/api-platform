package com.api.apigateway;

import com.api.provider.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;


@SpringBootApplication
@Service
@EnableDubbo
public class ApiGatewayApplication {

    @DubboReference
    private DemoService demoService;


	public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApiGatewayApplication.class, args);
        ApiGatewayApplication application = context.getBean(ApiGatewayApplication.class);
        String result = application.doSayHello("world");
        System.out.println("result = " + result);
	}

    public String doSayHello(String name) { return demoService.sayHello(name); }


//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("to_baidu", r -> r.path("/baidu")
//                        .uri("http://www.baidu.com/"))
//                .build();
//    }
}
