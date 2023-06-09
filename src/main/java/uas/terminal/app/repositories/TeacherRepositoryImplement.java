package uas.terminal.app.repositories;

import create.quiz.assessment.project.database.HikariDriverDatabase;
import uas.terminal.app.entities.Teacher;
import uas.terminal.app.sql.QuerySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherRepositoryImplement implements TeacherRepository{
    QuerySql querySql = new QuerySql();
    @Override
    public boolean addTeacherRepos(Teacher teacher) {

        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getAddTeacherSql())) {
            preparedStatement.setString(1, teacher.getName());
            int add = preparedStatement.executeUpdate();
            if (add == 1) return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Teacher findOneTeacherByNameRepos(Teacher teacher) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneTeacherByNameSql())) {
            preparedStatement.setString(1, teacher.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            Teacher resultTeacher = new Teacher();
            while (resultSet.next()) {
                resultTeacher.setId(resultSet.getLong("id"));
                resultTeacher.setName(resultSet.getString("name"));
                return resultTeacher;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
