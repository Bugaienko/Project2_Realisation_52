package interfaces;
/*
@author Sergey Bugaienko
*/

import model.User;

import java.util.List;
import java.util.Optional;

public interface IR_UserRepo {
    User addUser(String email, String password);
    User getUserById(int id);
    boolean isEmailExist(String email);
    Optional<User> authorisation(String email, String password);

    List<User> getAllUsers();

    Optional<User> getUserByEmail(String email);
}
