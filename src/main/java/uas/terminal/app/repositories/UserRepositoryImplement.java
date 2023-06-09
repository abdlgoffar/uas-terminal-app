package uas.terminal.app.repositories;

import create.quiz.assessment.project.database.HikariDriverDatabase;
import uas.terminal.app.entities.User;
import uas.terminal.app.sql.QuerySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImplement implements UserRepository{
    QuerySql querySql = new QuerySql();

    @Override
    public boolean addUserRepos(User user) {

        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(querySql.getAddUserSql())) {
            preparedStatement.setLong(1, user.getIdTeacher());
            preparedStatement.setLong(2, user.getIdStudent());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            int add = preparedStatement.executeUpdate();
            if (add == 1) return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    @Override
    public boolean registerUserTeacherRepos(User user) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getRegisterUserTeacherSql())) {
            preparedStatement.setLong(1, user.getIdTeacher());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            int add = preparedStatement.executeUpdate();
            if (add == 1) return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean registerUserStudentRepos(User user) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getRegisterUserStudentSql())) {
            preparedStatement.setLong(1, user.getIdStudent());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            int add = preparedStatement.executeUpdate();
            if (add == 1) return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean loginUserTeacherRepos(User user) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getLoginUserTeacherSql())) {
            preparedStatement.setLong(1, user.getIdTeacher());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            User resultUser = new User();
            while (resultSet.next()) {
                resultUser.setIdTeacher(resultSet.getLong("id_teacher"));
            }
            if (resultUser.getIdTeacher() != null) return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean loginUserStudentRepos(User user) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getLoginUserStudentSql())) {
            preparedStatement.setLong(1, user.getIdStudent());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            User resultUser = new User();
            while (resultSet.next()) {
                resultUser.setIdStudent(resultSet.getLong("id_student"));
            }
            if (resultUser.getIdStudent() != null) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public User findOneUserByNameRepos(User user) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneUserByNameSql())) {
            preparedStatement.setString(1, user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User resultUser = new User(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_teacher"),
                        resultSet.getLong("id_student"),
                        resultSet.getString("username"),
                        resultSet.getString("password"));
                return resultUser;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
