package edu.alura.tlozelda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.alura.tlozelda.principal.Menu;

@SpringBootApplication
public class TlozeldaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TlozeldaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu();
		menu.run();
	}

}
