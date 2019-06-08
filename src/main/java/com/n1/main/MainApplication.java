package com.n1.main;

import com.n1.main.domian.Basic;
import com.n1.main.domian.Profile;
import com.n1.main.repository.BasicRepository;
import com.n1.main.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}


	@Bean
	public CommandLineRunner runner(BasicRepository basicRepository, ProfileRepository profileRepository) throws Exception {
		return (args) -> IntStream.rangeClosed(1,3).forEach(index -> {
			Basic basic = basicRepository.save(Basic.builder()
			.name("홍길동"+index)
			.email("hong@gmail.com")
			.lable("도적"+index)
			.phone("012-3456-789"+index)
			.build()
			);

			Profile profile = profileRepository.save(Profile.builder()
			.network("트위터")
					.username("@hong"+index)
					.url("https://twitter/@home"+index)
					.createdDate(LocalDateTime.of(2019,05,21,19,33,21))
					.updatedDate(LocalDateTime.now())
					.build()
			);
		});
	}
}
