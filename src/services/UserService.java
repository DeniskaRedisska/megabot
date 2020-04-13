package services;

import dao.UserDao;
import dao.UserDaoRealisation;
import models.User;

public class UserService {
    private UserDao usersDao;

    public UserService() {
        usersDao = new UserDaoRealisation();
    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.saveUser(user);
    }

    public void deleteUser(User user) {
        usersDao.deleteUser(user);
    }
}
