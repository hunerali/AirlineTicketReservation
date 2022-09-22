package reservation.app.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.app.database.Database;
import reservation.app.entity.User;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    private UserDAO dao;
    private User user;
    private Database database;

    @BeforeEach
    void startUp() throws FileNotFoundException {
        database = new Database();
        dao = new UserDAO(database);
        database.startUp();
        user = new User(1, "hunar", "aliyev");
    }

    @Test
    void testGetAll() {
        dao.create(user);
        assertEquals(2, dao.getAll().size());
    }

    @Test
    void testCreateUser() {
        assertTrue(dao.create(user));
    }

    @Test
    void testDeleteUser() {
        dao.create(user);
        assertTrue(dao.delete(user));
    }


}