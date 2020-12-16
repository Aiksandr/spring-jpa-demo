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

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

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
			reportRepository.save(new Report("1"));
			reportRepository.save(new Report("2"));
			reportRepository.save(new Report("3"));

			final Pageable pageable = PageRequest.of(0, 20);
			final Page<ReportProjection> page = reportRepository.search(pageable);


			log.info("Size of stream {}", page.getNumberOfElements());
			final List<ReportProjection> content = page.getContent();
			for (ReportProjection reportProjection : content) {
				log.info("test {} {}", reportProjection.getId(), reportProjection.getCreateDate());
			}


		};
	}

}
