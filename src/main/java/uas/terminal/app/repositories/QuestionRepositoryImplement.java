package uas.terminal.app.repositories;

import create.quiz.assessment.project.database.HikariDriverDatabase;
import uas.terminal.app.entities.Question;
import uas.terminal.app.sql.QuerySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;

public class QuestionRepositoryImplement implements QuestionRepository{
    private QuerySql querySql = new QuerySql();
    @Override
    public boolean addQuestionRepos(Question question) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getAddQuestionSql())) {
            preparedStatement.setString(1, question.getName());
            preparedStatement.setLong(2, question.getIdAssessment());
            int add = preparedStatement.executeUpdate();
            if (add == 1) return true;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Question findOneQuestionByNameRepos(Question question) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindOneQuestionByNameSql())) {
            preparedStatement.setString(1, question.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            Question resultQuestion = new Question();
            while (resultSet.next()) {
                resultQuestion.setId(resultSet.getLong("id"));
                resultQuestion.setName(resultSet.getString("name"));
                return resultQuestion;
            }
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return null;
    }
    private Stack<Question> questions = new Stack<>();
    @Override
    public Stack<Question> findAllQuestionByIdAssessmentRepos(Question question) {
        try (Connection connection = HikariDriverDatabase.startHikariDataSourceConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(this.querySql.getFindAllQuestionByIdAssessmentSql())) {
            preparedStatement.setLong(1, question.getIdAssessment());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                this.questions.push(new Question(
                        resultSet.getLong("id"),
                        resultSet.getLong("id_assessment"),
                        resultSet.getString("name")));
            }
            if (this.questions.empty() == false) return this.questions;
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return null;
    }
}
