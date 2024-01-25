package com.sense;


import com.sense.repository.SensorDataRepository;
import com.sense.sensor.TemperatureSensor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SenseApplication {

	 public static void main(String[] args) {
		 SpringApplication.run(SenseApplication.class, args);


	 }
}
