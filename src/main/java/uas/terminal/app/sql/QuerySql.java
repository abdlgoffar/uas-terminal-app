package uas.terminal.app.sql;

import lombok.Getter;
public class QuerySql {
    /**
     * INSERT OR ADD QUERY
     */
    @Getter
    private String addAssessmentSql = "INSERT INTO assessment(id_teacher, name) VALUES(?, ?)";

    @Getter
    private String addQuestionSql = "INSERT INTO question(name, id_assessment) VALUES(?, ?)";

    @Getter
    private String addChoiceASql = "INSERT INTO choice_a(id_question, name) VALUES(?, ?)";

    @Getter
    private String addChoiceBSql = "INSERT INTO choice_b(id_question, name) VALUES(?, ?)";

    @Getter
    private String addChoiceCSql = "INSERT INTO choice_c(id_question, name) VALUES(?, ?)";

    @Getter
    private String addUserSql = "INSERT INTO user(id_teacher, id_student, username, password) VALUES(?, ?, ?, ?)";

    @Getter
    private String addTeacherSql = "INSERT INTO teacher(name) VALUES(?)";

    @Getter
    private String addStudentSql = "INSERT INTO student(name) VALUES(?)";
    /**
     * INSERT OR REGISTER QUERY
     */
    @Getter
    private String registerUserTeacherSql = "INSERT INTO user(id_teacher, username, password) VALUES( ?, ?, ?)";

    @Getter
    private String registerUserStudentSql = "INSERT INTO user(id_student, username, password) VALUES( ?, ?, ?)";
    /**
     * SELECT OR FIND QUERY
     */
    @Getter
    private String findOneQuestionByNameSql = "SELECT id, name FROM question WHERE name = ?";

    @Getter
    private String findOneTeacherByNameSql = "SELECT id, name FROM teacher WHERE name = ?";

    @Getter
    private String findOneStudentByNameSql = "SELECT id, name FROM student WHERE name = ?";

    @Getter
    private String findOneUserByNameSql = "SELECT id, id_teacher, id_student, username, password FROM user WHERE username = ?";

    @Getter
    private String findOneAssessmentByNameSql = "SELECT id, name FROM assessment WHERE name = ?";

    @Getter
    private String findOneAssessmentByIdTeacherAndNameSql = "SELECT id, name FROM assessment WHERE id_teacher = ? AND name = ?";

    @Getter
    private String findAllQuestionByIdAssessmentSql = "SELECT id, id_assessment, name FROM question WHERE id_assessment = ?";

    @Getter
    private String findOneChoiceAByIdQuestionSql = "SELECT name FROM choice_a WHERE id_question = ?";

    @Getter
    private String findOneChoiceBByIdQuestionSql = "SELECT name FROM choice_b WHERE id_question = ?";

    @Getter
    private String findOneChoiceCByIdQuestionSql = "SELECT name FROM choice_c WHERE id_question = ?";

    @Getter
    private String findOneChoiceAValueStatusTrueByIdQuestionSql = "SELECT status FROM choice_a WHERE id_question = ? AND status = true";

    @Getter
    private String findOneChoiceBValueStatusTrueByIdQuestionSql = "SELECT status FROM choice_b WHERE id_question = ? AND status = true";

    @Getter
    private String findOneChoiceCValueStatusTrueByIdQuestionSql = "SELECT status FROM choice_c WHERE id_question = ? AND status = true";
    /**
     * SELECT OR LOGIN QUERY
     */
    @Getter
    private String loginUserTeacherSql = "SELECT id, id_teacher, username, password FROM user WHERE id_teacher = ? AND password = ?";

    @Getter
    private String loginUserStudentSql = "SELECT id, id_student, username, password FROM user WHERE id_student = ? AND password = ?";

    /**
     * UPDATE OR CHANGE QUERY
     */
    @Getter
    private String updateOneChoiceAByIdQuestionSql = "UPDATE choice_a SET status = true WHERE id_question = ?";

    @Getter
    private String updateOneChoiceBByIdQuestionSql = "UPDATE choice_b SET status = true WHERE id_question = ?";

    @Getter
    private String updateOneChoiceCByIdQuestionSql = "UPDATE choice_c SET status = true WHERE id_question = ?";
}
