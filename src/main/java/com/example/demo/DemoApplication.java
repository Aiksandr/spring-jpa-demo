package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Slf4j
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	ReportRepository reportRepository;

	@Bean
	CommandLineRunner runnerScheduler() {
		return args -> {
			final Pageable pageable = PageRequest.of(1, 20);
			final Page<ReportProjection> reports = reportRepository.search(pageable);
			for (ReportProjection reportProjection : reports) {
				log.info("test {}", reportProjection.getCreateDate());
			}
		};
	}

}
