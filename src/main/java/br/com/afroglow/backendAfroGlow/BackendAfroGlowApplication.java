package br.com.afroglow.backendAfroGlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import br.com.afroglow.backendAfroGlow.Controllers.PagamentoController;

@SpringBootApplication
@ComponentScan(basePackageClasses = PagamentoController.class)
public class BackendAfroGlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAfroGlowApplication.class, args);
	
	}

}