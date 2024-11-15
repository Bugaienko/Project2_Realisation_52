package repository;
/*
@author Sergey Bugaienko
*/

import interfaces.IR_UserRepo;
import model.User;
import model.UserRole;
import repository.readWriters.UserReadWriter;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository implements IR_UserRepo {
    private final AtomicInteger currentUserId = new AtomicInteger(1);
    private final Map<Integer, User> usersMap;

    private final UserReadWriter userReadWrite = new UserReadWriter();

    public UserRepository() {
        List<User> users = new ArrayList<>(readUsersFromFile());
        usersMap = new HashMap<>();
        for (User user : users) {
            usersMap.put(user.getId(), user);
        }

//        initUsersTestData();
    }

    private List<User> readUsersFromFile() {
        List<User>  userList = userReadWrite.readFormFile();
        int maxId = userList.stream().mapToInt(User::getId).max().orElse(0);
        currentUserId.set(maxId + 1);
        return userList;
    }

    private void initUsersTestData() {

        User admin = new User(currentUserId.getAndIncrement(), "2", "2");
        admin.setRole(UserRole.ADMIN);
        List<User> userList = new ArrayList<>();
        userList.addAll(new ArrayList<>(List.of(
                new User(currentUserId.getAndIncrement(), "test@email.net", "qwerty!Q1"),
                new User(currentUserId.getAndIncrement(), "admin@email.net", "admin!Q1"),
                new User(currentUserId.getAndIncrement(), "user2@email.net", "qwerty!Q1"),
                new User(currentUserId.getAndIncrement(), "user3@email.net", "qwerty!Q1"),
                new User(currentUserId.getAndIncrement(), "1", "1"),
                admin

        )));
        userReadWrite.writeToFile(userList);
    }

    @Override
    public User addUser(String email, String password) {
        User user = new User(currentUserId.getAndIncrement(), email, password);
        usersMap.put(user.getId(), user);
        userReadWrite.addUserToFile(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(usersMap.values());
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return usersMap.values().stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    @Override
    public User getUserById(int id) {
        return usersMap.getOrDefault(id, null);
    }

    @Override
    public boolean isEmailExist(String email) {
        return usersMap.values().stream().map(User::getEmail).anyMatch(e -> e.equals(email));    }

    @Override
    public Optional<User> authorisation(String email, String password) {
        return usersMap.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }
}
