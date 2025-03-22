package td.com.example.travelDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"td.com.example.*"})
@EnableJpaRepositories
public class TravelDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelDemoApplication.class, args);
	}

}
