package com.sense.controller;

import com.sense.model.SensorData;
import com.sense.repository.SensorDataRepository;
import com.sense.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sensor-data")
public class SensorDataController {

    private final SensorDataService sensorDataService;
    private final SensorDataRepository sensorDataRepository;

    /**
     * Constructor for the initialization of sensorDataService.
     *
     * @param sensorDataService service for managing sensor data.
     */
    @Autowired
    public SensorDataController(SensorDataService sensorDataService,
                                SensorDataRepository sensorDataRepository) {
        this.sensorDataService = sensorDataService;
        this.sensorDataRepository = sensorDataRepository;
    }

    /**
     * Method to retrieve all Data.
     * @return All sensor data from the list.
     */
    @GetMapping
    public List<SensorData> getAllSensorData() {
        return sensorDataService.findAll();
    }

    /**
     * Method to retrieve sensor data by ID.
     *
     * @param id Returns the ID from the sensor data in the Sensor data List.
     * @return Returns the Data found on the specific ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SensorData> getSensorDataById(@PathVariable Long id) {
        return sensorDataService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * API to create new sensor data record
     *
     * @param sensorData The data to create.
     * @return the created sensor data.
     */
    @PostMapping
    public SensorData createSensorData(@RequestBody SensorData sensorData) {
        return sensorDataService.save(sensorData);
    }

    /**
     * API to update existing sensor data.
     *
     * @param id ID of the sensor data to update.
     * @param sensorDataDetails The new updated data to override the old data.
     * @return ResponseEntity Containing new data or a not found error.
     */
    @PutMapping
    public ResponseEntity<SensorData> getSensorDataById(@PathVariable Long id, @RequestBody SensorData sensorDataDetails) {
        return sensorDataService.findById(id)
                .map(sensorData -> {
                  sensorData.setValue(sensorDataDetails.getValue());
                  sensorData.setSensorType(sensorDataDetails.getSensorType());
                  sensorData.setTimestamp(sensorDataDetails.getTimestamp());
                  return ResponseEntity.ok(sensorDataRepository.save(sensorData));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * API to delete sensor data by ID.
     *
     * @param id ID of the sensor data to delete.
     * @return ResponseEntity with an indicator of the operation.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> DeleteSensorDataById(@PathVariable Long id){
        return sensorDataService.findById(id)
                .map(SensorData -> {
                    sensorDataService.deleteById(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());

    }


}
