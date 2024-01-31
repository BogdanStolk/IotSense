package com.sense.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entity class representing sensor data for the database
 * Annotations with JPA annotations to define how the data is stored and
 * retrieved from the database.
 */
@Data
@Entity
public class SensorData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identifier for each sensor record

    private String sensorType;
    private double value;
    private LocalDateTime timestamp; // Timestamp of when the data was stored


    // Default no-args constructor, needed for JPA
    public SensorData() {
    }

    /**
     * Constructs sensor data with the specified data
     * @param sensorType type of sensor
     * @param value recorded value by the sensor
     * @param timestamp timestamp of when data was recorded
     */
    public SensorData(String sensorType, double value, LocalDateTime timestamp) {
        this.sensorType = sensorType;
        this.value = value;
        this.timestamp = timestamp;
    }



    // Overridden to string method, for logging/debugging purposes
    @Override
    public String toString() {
        return """
                Sensordata:
                Sensor type: %s
                Value: %f
                Timestamp: : %s""".formatted(sensorType, value, timestamp.toString());
    }

}
