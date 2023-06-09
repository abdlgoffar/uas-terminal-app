package uas.terminal.app.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariDriverDatabase {
    private static HikariDataSource hikariDataSource;
    private static Connection connection;
    static {
        //CONFIGURATION DATABASE
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/create_quiz_assessment_project");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");
        //CONFIGURATION SERVICE DATABASE
        hikariConfig.setMaximumPoolSize(10);//max user for connect to database
        hikariConfig.setMinimumIdle(5);//max connection opened in database
        hikariConfig.setIdleTimeout(60_000);//time to closed connection database, if nothing user connect
        hikariConfig.setMaxLifetime(60_000 * 10);//max time user connect to database,before repeat connect
        hikariDataSource = new HikariDataSource(hikariConfig);
    }
    public static Connection startHikariDataSourceConnection() {
        try {
            connection = HikariDriverDatabase.hikariDataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
