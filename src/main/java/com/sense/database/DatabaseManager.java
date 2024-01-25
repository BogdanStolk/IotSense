package com.sense.database;

import com.sense.model.SensorData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {

    private Connection connection;

    public DatabaseManager(Connection connection) {
        this.connection = connection;
    }

    /**
     * method to configure the connection with the database,
     * with the correct corresponding data.
     *
     * @param data Recieved from the SensorData class
     * @throws SQLException
     */
    public void saveSensorData(SensorData data) throws SQLException {
        String sql = "INSERT INTO sensor_data (sensor_type, value, timestamp) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, data.getSensorType());
            pstmt.setDouble(2, data.getValue());
            pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(data.getTimestamp()));
            pstmt.executeUpdate();
        }
    }
}
