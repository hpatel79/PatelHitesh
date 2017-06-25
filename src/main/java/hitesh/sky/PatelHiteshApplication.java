package hitesh.sky;

import hitesh.sky.service.MovieService;
import hitesh.sky.service.ParentalControlLevelComparator;
import hitesh.sky.service.ParentalControlService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan("service")
public class PatelHiteshApplication {

	public PatelHiteshApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(PatelHiteshApplication.class, args);
		final List<String> validLevels = Arrays.asList("U", "PG", "12", "15", "18");
		String type;

		System.out.println("\n############################################");
		System.out.println("Available movie ids: 1, 2, 3");
		System.out.print("Valid Parental control levels:");
		validLevels.stream().map(level -> " " + level).forEach(System.out::print);
		System.out.println("\n############################################\n");

		final ParentalControlService parentalControlService =
				new ParentalControlService(new MovieService(), new ParentalControlLevelComparator(validLevels));
		Scanner scanner = new Scanner(System.in);
		do {
			new CommandLineClient(System.out, System.in, parentalControlService)
					.start();

			System.out.println("\n\n############################################");

			System.out.println("Do you want to watch any more movie? Y / N");
			type = scanner.next();

		}while(type.equalsIgnoreCase("Y"));

		System.out.println("\n\nThanks for using SKY Parental Control Service. Bye");

	}


}
