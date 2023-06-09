package uas.terminal.app.views;

import uas.terminal.app.entities.Student;
import uas.terminal.app.helpers.UserRequest;
import uas.terminal.app.repositories.StudentRepositoryImplement;
import uas.terminal.app.services.StudentService;
import uas.terminal.app.services.StudentServiceImplement;

public class StudentView {
    private StudentService studentService = new StudentServiceImplement(new StudentRepositoryImplement());
    public Long  addStudentView() {
        String requestStudentName = UserRequest.request("name student");
        Student student = new Student();
        student.setName(requestStudentName);
        this.studentService.addStudentService(student);
        Student oneStudentByNameService = this.studentService.findOneStudentByNameService(student);
        return oneStudentByNameService.getId();
    }
    public Student findOneStudentView(String name) {
        Student student = new Student();
        student.setName(name);
        Student oneStudentByNameService = this.studentService.findOneStudentByNameService(student);
        return  oneStudentByNameService;
    }
}
