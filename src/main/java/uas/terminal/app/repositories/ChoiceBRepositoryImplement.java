package uas.terminal.app.repositories;

import create.quiz.assessment.project.database.HikariDriverDatabase;
import uas.terminal.app.entities.ChoiceB;
import uas.terminal.app.sql.QuerySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChoiceBRepositoryImplement implements ChoiceBRepository{
    private QuerySql querySql = new QuerySql();
    @Override
    public boolean addChoiceBRepos(ChoiceB choiceB) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getAddChoiceBSql())) {
            preparedStatement.setLong(1, choiceB.getIdQuestion());
            preparedStatement.setString(2, choiceB.getName());
            int add = preparedStatement.executeUpdate();
            if (add == 1) return true;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return false;
    }

    @Override
    public ChoiceB findOneChoiceBByIdQuestionRepos(ChoiceB choiceB) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneChoiceBByIdQuestionSql())) {
            preparedStatement.setLong(1, choiceB.getIdQuestion());
            ResultSet resultSet = preparedStatement.executeQuery();
            ChoiceB resultChoiceB= new ChoiceB();
            while (resultSet.next()) {
                resultChoiceB.setName(resultSet.getString("name"));
            }
            if (resultChoiceB.getName() != null) return resultChoiceB;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean updateOneChoiceBByIdQuestionRepos(ChoiceB choiceB) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getUpdateOneChoiceBByIdQuestionSql())) {
            preparedStatement.setLong(1, choiceB.getIdQuestion());
            int update = preparedStatement.executeUpdate();
            if (update == 1) return true;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return false;
    }

    @Override
    public ChoiceB findOneChoiceBValueStatusTrueByIdQuestionRepos(ChoiceB choiceB) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneChoiceBValueStatusTrueByIdQuestionSql())) {
            preparedStatement.setLong(1, choiceB.getIdQuestion());
            ResultSet resultSet = preparedStatement.executeQuery();
            ChoiceB resultChoiceB = new ChoiceB();
            while (resultSet.next()) {
                resultChoiceB.setStatus(resultSet.getBoolean("status"));
            }
            if (resultChoiceB.isStatus()) return resultChoiceB;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return null;
    }

}
