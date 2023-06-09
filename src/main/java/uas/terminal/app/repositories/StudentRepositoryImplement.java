package uas.terminal.app.repositories;

import create.quiz.assessment.project.database.HikariDriverDatabase;
import uas.terminal.app.entities.Student;
import uas.terminal.app.sql.QuerySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRepositoryImplement implements StudentRepository{
    private QuerySql querySql = new QuerySql();
    @Override
    public boolean addStudentRepos(Student student) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getAddStudentSql())) {
            preparedStatement.setString(1, student.getName());
            int add = preparedStatement.executeUpdate();
            if (add == 1) return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Student findOneStudentByNameRepos(Student student) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneStudentByNameSql())) {
            preparedStatement.setString(1, student.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            Student resultStudent = new Student();
            while (resultSet.next()) {
                resultStudent.setId(resultSet.getLong("id"));
                resultStudent.setName(resultSet.getString("name"));
                return  resultStudent;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
