package hotelbooking;

import java.util.List;

public interface AbstractDAO<T extends HasGetIdMethod> {

    T getById(long id);

    List<T> getAll();

    T save(T t);

    void saveAll(List<T> t);

    void delete(T t);

    void deleteAll(List<T> t);

    void deleteById(long id);
}
