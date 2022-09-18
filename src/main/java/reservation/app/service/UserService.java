package reservation.app.service;

import reservation.app.dao.UserDAO;
import reservation.app.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    public User getUser(int id) {
        return userDAO.get(id);
    }

    public boolean register(User user) {
        return userDAO.create(user);
    }

    public boolean login(String username, String password) {
        Optional<User> search = userDAO.getAll().stream()
                .filter(user -> user.getUsername().equals(username)
                        && user.getPassword().equals(password)).findFirst();
        return search.isPresent();
    }

    public boolean delete(int id) {
        return userDAO.delete(id);
    }
}
