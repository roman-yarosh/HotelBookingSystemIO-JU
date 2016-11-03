package hotelbooking;

import java.util.List;

public class UserDAO extends AbstractDAOImpl<User> {

    @Override
    public User getById(long id) {
        return super.getById(id);
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public User save(User user) {
        return super.save(user);
    }

    @Override
    public void saveAll(List<User> t) {
        super.saveAll(t);
    }

    @Override
    public void delete(User user) {
        super.delete(user);
    }

    @Override
    public void deleteAll(List<User> t) {
        super.deleteAll(t);
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
    }
}
