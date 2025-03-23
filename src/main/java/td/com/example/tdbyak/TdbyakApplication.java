package td.com.example.tdbyak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"td.com.example.tdbyak*"})
@EnableJpaRepositories
public class TdbyakApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdbyakApplication.class, args);
	}

}
