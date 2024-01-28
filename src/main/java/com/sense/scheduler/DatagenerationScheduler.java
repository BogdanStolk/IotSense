package com.sense.scheduler;


import com.sense.model.SensorData;
import com.sense.sensor.Sensor;
import com.sense.service.SensorDataService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * schedule class for the generation of simulated data at regular intervals
 */
@Component
@EnableScheduling
public class DatagenerationScheduler {

    private final SensorDataService sensorDataService;
    private final List<Sensor> sensors;

    public DatagenerationScheduler(SensorDataService sensorDataService, List<Sensor> sensors) {
        this.sensorDataService = sensorDataService;
        this.sensors = sensors;
    }


    @Scheduled(fixedRate = 10000) // executing every 10 seconds
    public void generateAndStoreData() {
        sensors.forEach(s -> {
            double value = s.generateData();
            SensorData sensorData = new SensorData(s.getType(), value, LocalDateTime.now());
            sensorDataService.save(sensorData);
        });
    }


}
