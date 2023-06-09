package uas.terminal.app.views;

import uas.terminal.app.entities.Assessment;
import uas.terminal.app.entities.Student;
import uas.terminal.app.entities.Teacher;
import uas.terminal.app.entities.User;
import uas.terminal.app.helpers.UserRequest;
import uas.terminal.app.repositories.UserRepositoryImplement;
import uas.terminal.app.services.UserService;
import uas.terminal.app.services.UserServiceImplement;

public class UserView {
    private UserService userService = new UserServiceImplement(new UserRepositoryImplement());

    public void registerUserView() {
        String requestTeacherOrStudent = UserRequest.request("tekan (0) jika anda guru\ntekan (1) jika anda murid\nrequest ->");
        if (requestTeacherOrStudent.equals("0")) {
            TeacherView teacherView = new TeacherView();
            Long idTeacher = teacherView.addTeacherView();
            User user = new User();
            user.setIdTeacher(idTeacher);
            String requestUsernameUser = UserRequest.request("username");
            user.setUsername(requestUsernameUser);
            String requestPasswordUser = UserRequest.request("password");
            user.setPassword(requestPasswordUser);
            this.userService.registerUserTeacherService(user);
        } else if (requestTeacherOrStudent.equals("1")) {
            StudentView studentView = new StudentView();
            Long idStudent = studentView.addStudentView();
            User user = new User();
            user.setIdStudent(idStudent);
            String requestUsernameUser = UserRequest.request("username");
            user.setUsername(requestUsernameUser);
            String requestPasswordUser = UserRequest.request("password");
            user.setPassword(requestPasswordUser);
            this.userService.registerUserStudentService(user);
        }
    }
    public void loginUserView() {
        System.out.println("-sign in-");
        String username = UserRequest.request("username");
        String password = UserRequest.request("password");
        TeacherView teacherView = new TeacherView();
        Teacher teacher = teacherView.findOneTeacherView(username);
        StudentView studentView = new StudentView();
        Student student = studentView.findOneStudentView(username);
        if (teacher != null) {
            User user = new User();
            user.setIdTeacher(teacher.getId());
            user.setPassword(password);
            boolean loginUserTeacherService = this.userService.loginUserTeacherService(user);
            if (loginUserTeacherService) {
                AssessmentView assessmentView = new AssessmentView();
                assessmentView.addAssessmentView(teacher.getId());
            } else {
                System.out.println("invalid password or username");
            }
            return;
        } else if (student != null) {
            User user = new User();
            user.setIdStudent(student.getId());
            user.setPassword(password);
            boolean loginUserStudentService = this.userService.loginUserStudentService(user);
            if (loginUserStudentService) {
                System.out.println("attempt assessment");
                String requestWhatTeacher = UserRequest.request("what is the teacher's name");
                TeacherView teacherView1  = new TeacherView();
                Teacher oneTeacherView = teacherView1.findOneTeacherView(requestWhatTeacher);
                String requestAssessmentNameFromTeacher = UserRequest.request("assessment name from teacher");
                AssessmentView assessmentView = new AssessmentView();
                Assessment oneAssessmentByIdTeacherAndNameView = assessmentView.findOneAssessmentByIdTeacherAndNameView(oneTeacherView.getId(), requestAssessmentNameFromTeacher);
                QuestionView questionView = new QuestionView();
                questionView.findAllQuestionByIdAssessment(oneAssessmentByIdTeacherAndNameView.getId());
            } else {
                System.out.println("invalid password or username");
            }
            return;
        } else {
            System.out.println("you don't have an account");
            return;
        }
    }
}
