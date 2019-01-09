package volodko.ksenia.dao.network;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import volodko.ksenia.dao.AbstractDao;
import volodko.ksenia.interfaces.dao.network.IMessagesDao;
import volodko.ksenia.model.network.Message;
import volodko.ksenia.model.network.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class MessagesDao extends AbstractDao implements IMessagesDao {
    @Override
    public List<?> list() {
        return null;
    }

    public List<Message> selectReceivedNextWith(User user, int lot){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Message> query = builder.createQuery(Message.class);
        Root<Message> root = query.from(Message.class);
        query.select(root).where(builder.equal(root.get("user").get("id"),user.getId()));
        query.orderBy(builder.desc(root.get("date")));
        Query<Message> q = session.createQuery(query).setMaxResults(lot);
        List<Message> messages = q.getResultList();
        return messages;
    }

    public List<Message> selectSentNextWith(User user, int lot){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Message> query = builder.createQuery(Message.class);
        Root<Message> root = query.from(Message.class);
        query.select(root).where(builder.equal(root.get("sender").get("id"),user.getId()));
        query.orderBy(builder.desc(root.get("date")));
        Query<Message> q = session.createQuery(query).setMaxResults(lot);
        List<Message> messages = q.getResultList();
        return messages;
    }
}
