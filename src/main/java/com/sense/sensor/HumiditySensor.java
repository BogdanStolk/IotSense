package com.sense.sensor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Class representing a humidity sensor
 * Simulate data based on de time of day + seasonal changes *
 * a noise factor to simulate real-world sensor hardware imperfections.
 */
public class HumiditySensor implements Sensor {

    // Constant values for min & max humidity percentage + noise factor
    private static final double MIN_HUMIDITY = 55.0;
    private static final double MAX_HUMIDITY = 75.0;
    private static final double NOISE_FACTOR = 0.2;

    // Declaring sensor type
    @Override
    public String getType() {
        return "Humidity sensor";
    }

    /**
     * Generates humidity data.
     * Calculates the humidity based on a base value,
     * time of day variations, seasonal changes and random noise.
     *
     * @return double representing the simulated humidity.
     */
    @Override
    public double generateData() {

        double baseHumidity = (MIN_HUMIDITY + MAX_HUMIDITY) / 2;
        return baseHumidity + seasonalVariation() + dailyVariation() + applyNoise();
    }

    /**
     *  Seasonal changes are applied from highest to lowest humidity ->
     *  21 June = highest humidity, 21 December lowest.
     *
     * @return double Percentage of humidity, based on a given day.
     */
    private double seasonalVariation() {

        double dayOfYear = LocalDate.now().getDayOfYear();

        // Sinusoidal function to create a dynamic and realistic simulation of
        // humidity changes during the year 0.44 * Math.PI translates to 21 december,
        // representing the day with the lowest humidity of the year. 25 represents the total
        // amount of fluctuation of the wave
        return  7 * Math.sin((2 * Math.PI / 365) * dayOfYear - 0.44 * Math.PI);
    }

    /**
     * Applies time-based variation to the humidity.
     * This method adjusts the humidity based on the hour of the day,
     * simulating daily humidity fluctuations(lowest humidity begin during early morning).
     * 15:00 = highest humidity, 03:00 = lowest humidity.
     *
     * @return double Percentage of humidity, based on the time of day.
     */
    private double dailyVariation() {

        double hour = LocalTime.now().getHour();
        // Formula is similar to the seasonalVariation, with changes to simulate
        // daily fluctuations in humidity
        return 7 * Math.sin((2 * Math.PI / 24) * hour - (Math.PI / 2));
    }

    /**
     * Applies random noise to the humidity.
     * This method simulates sensor inaccuracies and environmental noise.
     *
     * @return double representing the random noise to be added to the humidity.
     */
    private double applyNoise() {
        return (Math.random() - 0.5) * NOISE_FACTOR;
    }
}
