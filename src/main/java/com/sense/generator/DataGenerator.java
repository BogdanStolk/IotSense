package com.sense.generator;

import com.sense.model.SensorData;
import com.sense.sensor.Sensor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for generating a list of sensor data.
 * All the sensors passed to the addSensor method will be added to the list of sensors
 */
public class DataGenerator {

    // list of Sensor objects
    private List<Sensor> sensors;

    // constructor which initializes an empty list of sensors
    public DataGenerator() {
        sensors = new ArrayList<>();
    }

    // method for adding Sensor objects to the list of sensors
    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }

    /**
     * returns data for ech sensor in the list with the enhanced for-loop.
     * collects data from each sensor and adds it to the sensorDataList
     *
     * @return List of sensorData objects, displaying the specified data.
     */
    public List<SensorData> generateData() {

        // new list of SensorData objects for the sensor data
        List<SensorData> sensorDataList = new ArrayList<>();

        for (Sensor sensor : sensors) {
            double value = sensor.generateData();
            SensorData data = new SensorData(sensor.getType(), value, LocalDateTime.now());
            sensorDataList.add(data);
        }
        return sensorDataList;
    }

}
