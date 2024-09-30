package com.techstackengineer.springboot.tutorials.searchapi;

import com.techstackengineer.springboot.tutorials.searchapi.repository.Tutorial;
import com.techstackengineer.springboot.tutorials.searchapi.repository.TutorialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SearchApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchApiApplication.class, args);
	}


	//@Bean
	CommandLineRunner loadTutorials(TutorialRepository tutorialRepository) {
		Tutorial tutorial1 = new Tutorial(10001L, "Spring Boot", "Learn about Spring Boot",
				"Spring Framework", LocalDate.now().minusMonths(1));
		Tutorial tutorial2 = new Tutorial(10002L, "Spring Cloud", "Learn about Spring cloud",
				"Spring Framework", LocalDate.now().minusMonths(2));
		Tutorial tutorial3 = new Tutorial(10003L, "Spring Data", "Learn about Spring data",
				"Spring Framework", LocalDate.now().minusMonths(3));
		Tutorial tutorial4 = new Tutorial(10004L, "Spring Batch", "Learn about Spring Batch",
				"Spring Framework", LocalDate.now());
		Tutorial tutorial5 = new Tutorial(10005L, "REST", "Learn about API Design",
				"API Design", LocalDate.now().minusWeeks(1));
		Tutorial tutorial6 = new Tutorial(10006L, "Core Java", "Learn about Cor Java",
				"Java", LocalDate.now().minusWeeks(2));
		Tutorial tutorial7 = new Tutorial(10007L, "Java Collections", "Learn about Java Collections",
				"Java", LocalDate.now().minusWeeks(3));
		Tutorial tutorial8 = new Tutorial(10008L, "Micro Services", "Learn about Micro Services",
				"Micro Services", LocalDate.now().minusWeeks(4));
		Tutorial tutorial9 = new Tutorial(10009L, "SQL", "Learn about SQL",
				"Data Base", LocalDate.now().minusWeeks(5));
		Tutorial tutorial10 = new Tutorial(10010L, "NO SQL", "Learn about NO SQL",
				"Data Base", LocalDate.now().minusDays(6));

		Tutorial tutorial11 = new Tutorial(10011L, "Clean Code Principles", "Learn about Clean Code Principles",
				"Java", LocalDate.now().minusDays(15));
		Tutorial tutorial12 = new Tutorial(10012L, "Java Streams", "Learn about Java Streams",
				"Java", LocalDate.now().minusDays(20));
		Tutorial tutorial13 = new Tutorial(10013L, "Spring Data", "Learn about Spring data",
				"LLD", LocalDate.now().minusDays(35));
		Tutorial tutorial14 = new Tutorial(10014L, "SOLID principles", "Learn about SOLID principles",
				"Low Level Design", LocalDate.now());
		Tutorial tutorial15 = new Tutorial(10015L, "API Architectural Styles", "Learn about API Architectural Styles",
				"API Design", LocalDate.now().minusDays(11));
		Tutorial tutorial16 = new Tutorial(10016L, "API Event Driven architecture", "Learn about API Event Driven architecture",
				"API Design", LocalDate.now().minusDays(22));
		Tutorial tutorial17 = new Tutorial(10017L, "Maven", "Learn about Maven",
				"Spring Framework", LocalDate.now().minusDays(50));
		Tutorial tutorial18 = new Tutorial(10018L, "AWS EKS", "Learn about AWS",
				"AWS", LocalDate.now().minusDays(65));
		Tutorial tutorial19 = new Tutorial(10019L, "AWS Batch", "Learn about AWS Batch",
				"AWS", LocalDate.now().minusDays(78));
		Tutorial tutorial20 = new Tutorial(10020L, "AWS DynamoDB", "Learn about AWS DynamoDB",
				"AWS", LocalDate.now().minusDays(90));


		return (args) -> {
			tutorialRepository.saveAll(List.of(tutorial1, tutorial2, tutorial3, tutorial4, tutorial5,
					tutorial6, tutorial7, tutorial8, tutorial9, tutorial10));

		};
	}
}
