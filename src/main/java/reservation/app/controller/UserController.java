package reservation.app.controller;

import reservation.app.entity.User;
import reservation.app.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public User getUser(int id) {
        return userService.getUser(id);
    }

    public boolean register(User user) {
        return userService.register(user);
    }

    public boolean login(String username, String password) {
        return userService.login(username,password);
    }

    public boolean delete(int id) {
        return userService.delete(id);
    }
}
