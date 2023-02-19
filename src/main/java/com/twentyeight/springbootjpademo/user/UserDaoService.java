package com.twentyeight.springbootjpademo.user;

import com.twentyeight.springbootjpademo.exception.UserNotFountException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1, "Chirag", "Pune"));
        userList.add(new User(2, "Mayuri", "Pune"));
        userList.add(new User(3, "Nil", "Pune"));
    }

    public List<User> getUsers() {
        return userList;
    }

    public User createUser(User user) {
        userList.add(user);
        return user;
    }

    public User findUser(int userid) {
        User user1 = userList.stream().filter(user -> user.getUserId() == userid).findAny().orElse(null);
        if (user1 == null)
            throw new UserNotFountException("User id - " + userid + " not found");
        return user1;
    }

    public String deleteUser(int userid) {
        boolean isDeleted = userList.removeIf(user -> user.getUserId() == userid);
        if (!isDeleted)
            throw new UserNotFountException("User id - " + userid + " not found");
        return "User deleted";
    }
}
