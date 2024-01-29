package com.sense.service;

import com.sense.model.SensorData;
import com.sense.repository.SensorDataRepository;
import com.sense.sensor.User;
import com.sense.sensor.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// service class for managing data which provides CRUD operations
@Service
public class SensorDataService {


    private final SensorDataRepository sensorDataRepository;

    /**
     * Constructor for the SensorDataService
     * @param sensorDataRepository Repository for the sensor data
     */
    @Autowired
    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    /**
     * Collects all sensor data records
     * @return list of sensor data
     */
    public List<SensorData> findAll() {
        return sensorDataRepository.findAll();
    }

    /**
     * find sensor data by ID
     *
     * @param id ID of the Sensor data
     * @return Optional containing sensor data, or an empty optional if no data is found.
     */
    public Optional<SensorData> findById(Long id) {
        return sensorDataRepository.findById(id);
    }

    /**
     * Delete sensor data by ID
     *
     * @param id The ID of the data to be deleted
     */
    public void deleteById(Long id) {
        sensorDataRepository.deleteById(id);
    }

    /**
     * save sensor data record
     *
     * @param sensorData The data to be saved.
     * @return  The saved data object.
     */
    public SensorData save(SensorData sensorData) {
        // Logging for saving
        System.out.println(sensorData);
        return sensorDataRepository.save(sensorData);
    }
}
