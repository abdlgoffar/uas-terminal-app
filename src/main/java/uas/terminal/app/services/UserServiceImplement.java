package uas.terminal.app.services;

import uas.terminal.app.entities.User;
import uas.terminal.app.repositories.UserRepository;

public class UserServiceImplement implements UserService{

    private UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean addUserService(User user) {
        boolean addUserRepos = this.userRepository.addUserRepos(user);
        if (addUserRepos) return true;
        return false;
    }


    @Override
    public boolean registerUserTeacherService(User user) {
        boolean registerUserTeacherRepos = this.userRepository.registerUserTeacherRepos(user);
        if (registerUserTeacherRepos) return true;
        return false;
    }

    @Override
    public boolean registerUserStudentService(User user) {
        boolean registerUserStudentRepos = this.userRepository.registerUserStudentRepos(user);
        if (registerUserStudentRepos) return true;
        return false;
    }

    @Override
    public boolean loginUserTeacherService(User user) {
        boolean loginUserTeacherRepos = this.userRepository.loginUserTeacherRepos(user);
        if (loginUserTeacherRepos) return true;
        return false;
    }

    @Override
    public boolean loginUserStudentService(User user) {
        boolean loginUserStudentRepos = this.userRepository.loginUserStudentRepos(user);
        if (loginUserStudentRepos) return true;
        return false;
    }

}
