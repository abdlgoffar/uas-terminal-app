package uas.terminal.app.repositories;

import uas.terminal.app.entities.User;

public interface UserRepository {
    public abstract boolean addUserRepos(User user);
    public abstract boolean registerUserTeacherRepos(User user);

    public abstract boolean registerUserStudentRepos(User user);

    public abstract boolean loginUserTeacherRepos(User user);

    public abstract boolean loginUserStudentRepos(User user);

    public abstract User findOneUserByNameRepos(User user);
}
