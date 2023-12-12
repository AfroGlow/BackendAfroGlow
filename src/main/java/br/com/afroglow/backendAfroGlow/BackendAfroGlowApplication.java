package br.com.afroglow.backendAfroGlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "br.com.afroglow.backendAfroGlow")
public class BackendAfroGlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendAfroGlowApplication.class, args);
    }
}