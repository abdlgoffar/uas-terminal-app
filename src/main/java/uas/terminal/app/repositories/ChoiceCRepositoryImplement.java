package uas.terminal.app.repositories;

import create.quiz.assessment.project.database.HikariDriverDatabase;
import uas.terminal.app.entities.ChoiceC;
import uas.terminal.app.sql.QuerySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChoiceCRepositoryImplement implements ChoiceCRepository{
    private QuerySql querySql = new QuerySql();

    @Override
    public boolean addChoiceCRepos(ChoiceC choiceC) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getAddChoiceCSql())) {
            preparedStatement.setLong(1, choiceC.getIdQuestion());
            preparedStatement.setString(2, choiceC.getName());
            int add = preparedStatement.executeUpdate();
            if (add == 1) return true;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return false;
    }

    @Override
    public ChoiceC findOneChoiceCByIdQuestionRepos(ChoiceC choiceC) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneChoiceCByIdQuestionSql())) {
            preparedStatement.setLong(1, choiceC.getIdQuestion());
            ResultSet resultSet = preparedStatement.executeQuery();
            ChoiceC resultChoiceC= new ChoiceC();
            while (resultSet.next()) {
                resultChoiceC.setName(resultSet.getString("name"));
            }
            if (resultChoiceC.getName() != null) return resultChoiceC;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean updateOneChoiceCByIdQuestionRepos(ChoiceC choiceC) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getUpdateOneChoiceCByIdQuestionSql())) {
            preparedStatement.setLong(1, choiceC.getIdQuestion());
            int update = preparedStatement.executeUpdate();
            if (update == 1) return true;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return false;
    }

    @Override
    public ChoiceC findOneChoiceCValueStatusTrueByIdQuestionRepos(ChoiceC choiceC) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneChoiceCValueStatusTrueByIdQuestionSql())) {
            preparedStatement.setLong(1, choiceC.getIdQuestion());
            ResultSet resultSet = preparedStatement.executeQuery();
            ChoiceC resultChoiceC = new ChoiceC();
            while (resultSet.next()) {
                resultChoiceC.setStatus(resultSet.getBoolean("status"));
            }
            if (resultChoiceC.isStatus()) return resultChoiceC;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return null;
    }
}
