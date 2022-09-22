package reservation.app.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.app.dao.UserDAO;
import reservation.app.database.Database;
import reservation.app.entity.User;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService service;
    private User user;

    @BeforeEach
    void startUo() throws FileNotFoundException {
        Database database = new Database();
        UserDAO dao = new UserDAO(database);
        service = new UserService(dao);
        database.startUp();

        user = new User(2, "huner", "1234");

    }

    @Test
    void testGetAll() {
        assertEquals(1, service.getAllUsers().size());
    }

    @Test
    void testRegister() {
        assertTrue(service.register(user));
    }

    @Test
    void getUser() {
        service.register(user);
        assertEquals(user, service.getAllUsers().get(1));
    }

    @Test
    void testLogin(){
        service.register(user);
        assertTrue(service.login("huner","1234"));
    }

}