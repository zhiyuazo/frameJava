package boot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@ComponentScan(value="trytest")
@EnableJpaRepositories("trytest")
@EntityScan("trytest")
@MapperScan(value = "trytest")
public class entry {
	public static void main(String[] args) {
		SpringApplication.run(entry.class, args);
	}
	
}
