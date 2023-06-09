package uas.terminal.app.services;

import uas.terminal.app.entities.Student;


public interface StudentService {
    public abstract boolean addStudentService(Student student);
    public  abstract Student findOneStudentByNameService(Student student);
}
