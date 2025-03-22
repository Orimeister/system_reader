package orimeister.projects.systerm_reader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SystemReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemReaderApplication.class, args);
	}

}
