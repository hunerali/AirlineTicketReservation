package reservation.app.service;

import reservation.app.dao.UserDAO;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
