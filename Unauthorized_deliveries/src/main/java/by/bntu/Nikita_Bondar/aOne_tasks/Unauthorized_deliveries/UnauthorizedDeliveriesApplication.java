package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries;

import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.CSVprocessors.csvProcessor;
import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.services.DBfiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication

public class UnauthorizedDeliveriesApplication {

	@Autowired DBfiller dBfiller;

	public static void main(String[] args) {
		SpringApplication.run(UnauthorizedDeliveriesApplication.class, args);
	}

}
