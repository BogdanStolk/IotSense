package com.sense.service;

import com.sense.model.SensorData;
import com.sense.repository.SensorDataRepository;
import com.sense.sensor.HumiditySensor;
import com.sense.sensor.TemperatureSensor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SensorDataServiceTest {

    // Mock the repository to prevent interaction with the database during the test
    @Mock
    private SensorDataRepository sensorDataRepository;

    @InjectMocks
    SensorDataService sensorDataService;

    private SensorData sensorData1, sensorData2;

    // test data
    @BeforeEach
    void setUp() {
        sensorData1 = new SensorData("Humidity", 50.4, LocalDateTime.now());
        sensorData2 = new SensorData("Humidity", 50.5, LocalDateTime.now());


    }

    @Test
    void testSensorDataGenerator() {

        // instantiation of the sensor classes
        HumiditySensor humiditySensor = new HumiditySensor();
        TemperatureSensor temperatureSensor = new TemperatureSensor();

        // Set a specific time and date at: 2024, June, 21, 15:00 hours
        LocalDateTime testDateTime = LocalDateTime.of(2024, 6,21, 15, 0);
        System.setProperty("time.of.testing", testDateTime.toString());

        // Generate sensor data
        double humidityValue = humiditySensor.generateData();
        double temperatureValue = temperatureSensor.generateData();

        // Assert generated values within expected realistic ranges
        assertTrue(humidityValue >= 55 && humidityValue < 100, "Unexpected humidity value: " + humidityValue);
        assertTrue(temperatureValue >= 0 && temperatureValue < 50, "Unexpected temperature value: " + temperatureValue);

        // Clear system property after the test to avoid conflicts with other tests
        System.clearProperty("time.of.testing");



    }


    @Test
    void findAll() {

        // Mock repository response
        when(sensorDataRepository.findAll()).thenReturn(Arrays.asList(sensorData1, sensorData2));
        // Call this method
        List<SensorData> result = sensorDataService.findAll();
        // Assert if the result is not null & the list size is as expected
        assertNotNull(result);
        assertEquals(2, result.size());
        // Verify interaction with the mock of sensorDataRepository
        verify(sensorDataRepository).findAll();
    }

    @Test
    void findById() {

        // Mock repository response
        when(sensorDataRepository.findById(1L)).thenReturn(Optional.of(sensorData1));
        // Call this method
        Optional<SensorData> result = sensorDataService.findById(1L);
        // Assert if the result is not null & the list size is as expected
        assertTrue(result.isPresent());
        assertEquals(sensorData1, result.get());
        // Verify interaction with the mock of sensorDataRepository
        verify(sensorDataRepository).findById(1L);

    }

    @Test
    void deleteById() {

        // Mock repository response
        doNothing().when(sensorDataRepository).deleteById(1L);
        // Call this method
        sensorDataService.deleteById(1L);
        // Verify interaction with the mock of sensorDataRepository
        verify(sensorDataRepository).deleteById(1L);

    }

    @Test
    void save() {

        // Mock repository response
        when(sensorDataRepository.save(sensorData1)).thenReturn(sensorData1);
        // Call this method
        SensorData result = sensorDataService.save(sensorData1);
        // Assert if the result is not null & the list size is as expected
        assertNotNull(result);
        assertEquals(sensorData1, result);
        // Verify interaction with the mock of sensorDataRepository
        verify(sensorDataRepository).save(sensorData1);

    }
}