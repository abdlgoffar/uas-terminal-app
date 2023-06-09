package uas.terminal.app.repositories;

import create.quiz.assessment.project.database.HikariDriverDatabase;
import uas.terminal.app.entities.Assessment;
import uas.terminal.app.sql.QuerySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssessmentRepositoryImplement implements AssessmentRepository{

    private QuerySql querySql = new QuerySql();
    @Override
    public boolean addAssessmentRepos(Assessment assessment) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getAddAssessmentSql())) {
            preparedStatement.setLong(1, assessment.getIdTeacher());
            preparedStatement.setString(2, assessment.getName());
            int add = preparedStatement.executeUpdate();
            if (add == 1) return true;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Assessment findOneAssessmentByNameRepos(Assessment assessment) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneAssessmentByNameSql())) {
           preparedStatement.setString(1, assessment.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            Assessment resultAssessment = new Assessment();
            while (resultSet.next()) {
                resultAssessment.setId(resultSet.getLong("id"));
            }
            if (resultAssessment.getId() != null) return resultAssessment;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Assessment findOneAssessmentByIdTeacherAndNameRepos(Assessment assessment) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneAssessmentByIdTeacherAndNameSql())) {
           preparedStatement.setLong(1, assessment.getIdTeacher());
           preparedStatement.setString(2, assessment.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            Assessment resultAssessment = new Assessment();
            while (resultSet.next()) {
              resultAssessment.setId(resultSet.getLong("id"));
            }
            if (resultAssessment.getId() != null) return resultAssessment;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return null;
    }



}

