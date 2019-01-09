package volodko.ksenia.interfaces.dao;

import volodko.ksenia.model.hockey.Game;

import java.util.List;

public interface IDao {
    void save(Object object);

    void update(Object object);

    void saveOrUpdate(Object object);

    List<?> list();
}
