package dao;

import models.User;

public interface UserDao {
    User findById(int id);

    void saveUser(User user);

    void deleteUser(User user);
}
