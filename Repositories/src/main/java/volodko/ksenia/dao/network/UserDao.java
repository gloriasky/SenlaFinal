package volodko.ksenia.dao.network;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import volodko.ksenia.dao.AbstractDao;
import volodko.ksenia.interfaces.dao.network.IUserDao;
import volodko.ksenia.model.network.Login;
import volodko.ksenia.model.network.User;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Qualifier(value = "userDao")
public class UserDao extends AbstractDao implements IUserDao {

    @SuppressWarnings("unchecked")
    public List<?> list() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        Query<User> q = session.createQuery(query);
        List<User> users = q.getResultList();
        session.close();
        return users;
    }
    public User findNecessaryUser(User user){

        try (Session session = getSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);
            User necessaryUser = null;
            if (query != null) {
                Root<User> users = query.from(User.class);
                Join<User, Login> logins = users.join("loginInformation");
                query.where(builder.equal(users.get("loginInformation").get("login"), user.getLoginInformation().getLogin()))
                        .where(builder.equal(users.get("loginInformation").get("password"), user.getLoginInformation().getPassword()));
                query.select(users).distinct(true);
                TypedQuery<User> q = session.createQuery(query);
                necessaryUser = q.getResultList().get(0);
            }
            return necessaryUser;
        }
    }

}
