package uas.terminal.app.repositories;

import create.quiz.assessment.project.database.HikariDriverDatabase;
import uas.terminal.app.entities.ChoiceA;
import uas.terminal.app.sql.QuerySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChoiceARepositoryImplement implements ChoiceARepository {
    private QuerySql querySql = new QuerySql();

    @Override
    public boolean addChoiceARepos(ChoiceA choiceA) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getAddChoiceASql())) {
            preparedStatement.setLong(1, choiceA.getIdQuestion());
            preparedStatement.setString(2, choiceA.getName());
            int add = preparedStatement.executeUpdate();
            if (add == 1) return true;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return false;
    }

    @Override
    public ChoiceA findOneChoiceAByIdQuestionRepos(ChoiceA choiceA) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneChoiceAByIdQuestionSql())) {
            preparedStatement.setLong(1, choiceA.getIdQuestion());
            ResultSet resultSet = preparedStatement.executeQuery();
            ChoiceA resultChoiceA = new ChoiceA();
            while (resultSet.next()) {
                resultChoiceA.setName(resultSet.getString("name"));
            }
            if (resultChoiceA.getName() != null) return resultChoiceA;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean updateOneChoiceAByIdQuestionRepos(ChoiceA choiceA) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getUpdateOneChoiceAByIdQuestionSql())) {
            preparedStatement.setLong(1, choiceA.getIdQuestion());
            int update = preparedStatement.executeUpdate();
            if (update == 1) return true;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return false;
    }

    @Override
    public ChoiceA findOneChoiceAValueStatusTrueByIdQuestionRepos(ChoiceA choiceA) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneChoiceAValueStatusTrueByIdQuestionSql())) {
            preparedStatement.setLong(1, choiceA.getIdQuestion());
            ResultSet resultSet = preparedStatement.executeQuery();
            ChoiceA resultChoiceA = new ChoiceA();
            while (resultSet.next()) {
                resultChoiceA.setStatus(resultSet.getBoolean("status"));
            }
            if (resultChoiceA.isStatus()) return resultChoiceA;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return null;
    }
}

