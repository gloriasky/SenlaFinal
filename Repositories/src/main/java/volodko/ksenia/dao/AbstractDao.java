package volodko.ksenia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import volodko.ksenia.interfaces.dao.IDao;

import java.util.List;

@Repository
public abstract class AbstractDao implements IDao {
    @Autowired
    private SessionFactory sessionFactory;
    public abstract List<?> list();
    public void save(Object object){
        Session session = getSession();
        session.save(object);
        session.close();
    }
    public void update(Object object){
        Session session = getSession();
        session.update(object);
        session.close();
    }
    public void saveOrUpdate(Object object){
        Session session = getSession();
        session.saveOrUpdate(object);
        session.close();
    }
    protected Session getSession(){
        return sessionFactory.openSession();
    }
}
