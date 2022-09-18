package reservation.app.dao;

import reservation.app.entity.User;

import java.util.List;

public class UserDAO implements DAO<User>{
    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
