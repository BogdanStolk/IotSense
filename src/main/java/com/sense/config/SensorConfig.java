package com.sense.config;

import com.sense.sensor.HumiditySensor;
import com.sense.sensor.TemperatureSensor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for sensor beans.
 * Class uses Spring's @Configuration annotation to indicate that it
 * contains bean definitions. The methods annotated with @Bean will get
 * invoked by Spring at runtime to create and register these beans in the
 * Spring application context.
 * */
@Configuration
public class SensorConfig {

    /**
     * Creates and returns a TemperatureSensor bean.
     * This method defines a TemperatureSensor bean that will be managed by the Spring
     * container. Anytime a TemperatureSensor is required in the application, this
     * instance will be injected by Spring.
     *
     * @return A new instance of TemperatureSensor.
     */
    @Bean
    public TemperatureSensor temperatureSensor() {
        return new TemperatureSensor();
    }

    @Bean
    public HumiditySensor humiditySensor() {

        return new HumiditySensor() ;
    }
}
