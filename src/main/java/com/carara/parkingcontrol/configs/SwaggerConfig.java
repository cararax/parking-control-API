package com.carara.parkingcontrol.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("v1.0.0") String appVersion) {
        Contact contact = new Contact();
        contact.setName("Pedro Carara");
        contact.setUrl("https:github.com/cararax");
        contact.setEmail("cararax@gmail.com");
        Server server = new Server();
        server.setUrl("https://order-delivery-service.herokuapp.com/");
        server.setDescription("Deployment on Heroku");
        ArrayList<Server> servers = new ArrayList<>();
        servers.add(server);

        return new OpenAPI().info(new Info()
                        .title("Parking Spot API")
                        .version(appVersion)
                        .description("Parking Control API is a simple parking control service for condominiums.")
                        .contact(contact)
                        .license(new License().name("GPT 2")
                                .url("https://github.com/openai/gpt-2/blob/master/LICENSE")));
//                       .servers(servers);
    }
}
