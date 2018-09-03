package io.syndesis.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RouteBuilder route() {
        return new RouteBuilder() {
            public void configure() throws Exception {
                from("salesforce:syn_Lead_c?sObjectClass=io.syndesis.example.SalesforceIdentifier&sObjectQuery=SELECT+Id+FROM+Lead")
                    .enrich("salesforce:getSObject?rawPayload=true&sObjectName=Lead")
                    .convertBodyTo(String.class)
                    .to("log:sf?showAll=true&multiline=true");
            }
        };
    }
}
