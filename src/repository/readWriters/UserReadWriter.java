package repository.readWriters;
/*

@author Sergey Bugaienko
*/

import model.User;
import model.UserRole;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserReadWriter {
    private static final File FILE_USERS = new File(Paths.PATH, "users.data");
    private static final String DELIMITER = "|";

    public  List<User> readFormFile() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_USERS))) {
            String line;

            while ((line = reader.readLine()) != null) {
                users.add(parseUserFromString(line));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private User parseUserFromString(String line) {
        String[] data = line.split("\\"+DELIMITER);
        int id = Integer.parseInt(data[0]);
        String email = data[1];
        String password = data[2];
        UserRole role = UserRole.valueOf(data[3]);
        return new User(id, email, password, role);

    }

    public void writeToFile(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_USERS))) {
            if (!FILE_USERS.exists()) {
                FILE_USERS.createNewFile();
            }

            for (User user : users){
                writer.write(getStringFromUser(user));
                writer.newLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getStringFromUser(User user) {
//        if (user == null) throw new IllegalAccessException("empty user");
        StringBuilder sb = new StringBuilder();
        //TODO проблема повторяющегося ID
        sb.append(user.getId()).append(DELIMITER);
        sb.append(user.getEmail()).append(DELIMITER);
        sb.append(user.getPassword()).append(DELIMITER);
        sb.append(user.getRole().toString());

        return sb.toString();

    }

    public void addUserToFile(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_USERS, true))){
            String userString = getStringFromUser(user);
            writer.write(userString);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
