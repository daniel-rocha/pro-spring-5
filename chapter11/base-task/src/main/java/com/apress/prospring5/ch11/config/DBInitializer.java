package com.apress.prospring5.ch11.config;

import com.apress.prospring5.ch11.entities.Car;
import com.apress.prospring5.ch11.repos.CarRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by iuliana.cosmina on 4/23/17.
 */
@Service
public class DBInitializer {

	private Logger logger = LoggerFactory.getLogger(DBInitializer.class);
	@Autowired CarRepository carRepository;

	@PostConstruct
	public void initDB() {
		logger.info("Starting database initialization...");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Car car = new Car();
		car.setLicensePlate("GRAVITY-0405");
		car.setManufacturer("Ford");
		car.setManufactureDate(LocalDate.parse("2006-09-12", formatter));
		carRepository.save(car);

		car = new Car();
		car.setLicensePlate("CLARITY-0432");
		car.setManufacturer("Toyota");
		car.setManufactureDate(LocalDate.parse("2003-09-09", formatter));
		carRepository.save(car);

		car = new Car();
		car.setLicensePlate("ROSIE-0402");
		car.setManufacturer("Toyota");
		car.setManufactureDate(LocalDate.parse("2017-04-16", formatter));
		carRepository.save(car);

		logger.info("Database initialization finished.");
	}
}
