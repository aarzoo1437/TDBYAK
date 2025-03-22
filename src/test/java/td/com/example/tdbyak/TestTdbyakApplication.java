package td.com.example.tdbyak;

import org.springframework.boot.SpringApplication;

public class TestTdbyakApplication {

	public static void main(String[] args) {
		SpringApplication.from(TdbyakApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
