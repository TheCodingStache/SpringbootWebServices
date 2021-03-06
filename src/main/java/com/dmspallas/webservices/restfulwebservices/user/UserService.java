package com.dmspallas.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserService {
    private static List<User> users = new ArrayList<>();
    private int usersCount = 0;

    static {
        users.add(new User(1, "Dimitris", new Date()));
        users.add(new User(2, "Vaggelis", new Date()));
        users.add(new User(3, "Christos", new Date()));
        users.add(new User(4, "Vassilis", new Date()));
        users.add(new User(5, "George", new Date()));
        users.add(new User(6, "Gilipollas", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User saveUser(User user) {
        usersCount = user.getId();
        if (user.getId() != null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteUserById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
