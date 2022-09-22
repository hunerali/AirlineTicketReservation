package reservation.app.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.app.dao.UserDAO;
import reservation.app.database.Database;
import reservation.app.entity.User;
import reservation.app.service.UserService;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    private UserController controller;
    private User user;

    @BeforeEach
    void startUp() throws FileNotFoundException {
        Database database = new Database();
        UserDAO dao = new UserDAO(database);
        UserService service = new UserService(dao);
        controller = new UserController(service);
        database.startUp();
        user = new User(2, "huner", "1234");

    }

    @Test
    void getAllUsers() {
        assertEquals(1, controller.getAllUsers().size());
    }

    @Test
    void testRegistration() {
        assertTrue(controller.register(user));
    }

    @Test
    void testLogin() {
        assertTrue(controller.login("huner", "1234"));
    }
}