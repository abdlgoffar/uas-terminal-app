package uas.terminal.app.services;

import uas.terminal.app.entities.Student;
import uas.terminal.app.repositories.StudentRepository;

public class StudentServiceImplement implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImplement(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public boolean addStudentService(Student student) {
        boolean addStudentRepos = this.studentRepository.addStudentRepos(student);
        if (addStudentRepos) return true;
        return false;
    }

    @Override
    public Student findOneStudentByNameService(Student student) {
        Student oneStudentByNameRepos = this.studentRepository.findOneStudentByNameRepos(student);
        if (oneStudentByNameRepos != null) return oneStudentByNameRepos;
        return null;
    }
}
