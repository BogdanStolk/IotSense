package com.sense.sensor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *  Class representing a temperature sensor
 *  Simulate data based on de time of day +
 *  a noise factor to simulate real-world sensor hardware imperfections.
 */

public class TemperatureSensor implements Sensor {

    // Constant values for min & max temperatures(Celsius) + noise factor
    private static final double MIN_TEMP = -5.0;
    private static final double MAX_TEMP = 40.0;
    private static final double NOISE_FACTOR = 0.2;

    // Declaring sensor type
    @Override
    public String getType() {
        return "Temperature sensor";
    }

    /**
     * Generates temperature data.
     * Calculates the temperature based on a base value,
     * time of day variations, and random noise.
     *
     * @return double representing the simulated temperature.
     */
    @Override
    public double generateData() {

        double baseTemp = (MIN_TEMP + MAX_TEMP) / 2;
        return baseTemp + dailyVariation() + seasonalVariation() + applyNoise();
    }

    /**
     * Applies time-based variation to the temperature.
     * This method adjusts the temperature based on the hour of the day,
     * simulating daily temperature fluctuations. Setting 15:00 as the highest temperature.
     * 03:00 as the lowest temperature.
     *
     * @return double representing the temperature after applying time-based variation.
     */
    private double dailyVariation() {

        double hour = LocalTime.now().getHour();
        // Sinus function is at its peak at 15:00, representing the highest temp.
        return  7 * Math.sin((2 * Math.PI / 24) * hour - (15 * Math.PI / 12));
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
        return  7 * Math.sin((2 * Math.PI / 365) * dayOfYear - 172 * Math.PI / 365);
    }

    /**
     * Applies random noise to the temperature.
     * This method simulates sensor inaccuracies and environmental noise.
     *
     * @return double representing the random noise to be added to the temperature.
     */
    private double applyNoise() {

        return (Math.random() - 0.5) * NOISE_FACTOR;
    }
}
