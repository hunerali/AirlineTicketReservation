package reservation.app.dao;

import reservation.app.database.Database;
import reservation.app.entity.User;

import java.util.List;

public class UserDAO implements DAO<User> {
    private final Database database;

    public UserDAO(Database database) {
        this.database = database;
    }

    @Override
    public List<User> getAll() {
        return database.getUsers();
    }

    @Override
    public User get(int id) {
        return database.getUsers().get(id);
    }

    @Override
    public boolean create(User user) {
        return database.getUsers().add(user);
    }

    @Override
    public boolean delete(User user) {
        return database.getUsers().remove(user);
    }

    @Override
    public boolean delete(int id) {
        return database.getUsers().remove(database.getUsers().get(id));
    }
}
