package service;
/*
@author Sergey Bugaienko
*/

import interfaces.IR_UserRepo;
import interfaces.IS_UserService;
import model.User;
import repository.UserRepository;
import validators.EmailValidator;
import validators.PasswordValidator;
import validators.exceptions.EmailValidateException;
import validators.exceptions.PasswordValidateException;

import java.util.List;
import java.util.Optional;

public class UserService implements IS_UserService {

    private User activeUser;
    private final IR_UserRepo userRepository;

    public UserService(IR_UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> createUser(String email, String password) throws PasswordValidateException, EmailValidateException {
        EmailValidator.validate(email);
        PasswordValidator.validate(password);
        User user = null;
        if (!userRepository.isEmailExist(email)) {
            user = userRepository.addUser(email, password);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public Optional<User> getUserById(int id) {
        User user = userRepository.getUserById(id);
        return Optional.ofNullable(user);
    }

    @Override
    public User authorisation(String email, String password) {
        logout();
        Optional<User> optionalUser = userRepository.authorisation(email, password);
        optionalUser.ifPresent(user -> activeUser = user);

        return activeUser;
    }

    @Override
    public void logout() {
        activeUser = null;
    }

    @Override
    public User getActiveUser() {
        return activeUser;
    }
}
