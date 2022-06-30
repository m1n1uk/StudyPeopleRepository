package kr.inplat.sample2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Sample2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sample2Application.class, args);
	}

}
