package service.impl;

import entity.User;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserService implements Serializable {
    private List<User> names;

    public UserService() {
        this.names = new ArrayList<>();
    }

    public List<User> getNames() {
        return names;
    }

    public void addUser(String name, String email) {
        names.add(new User(name, email));
    }
}
