package uas.terminal.app.repositories;

import uas.terminal.app.entities.Student;

public interface StudentRepository {
    public abstract boolean addStudentRepos(Student student);

    public abstract Student findOneStudentByNameRepos(Student student);
}
