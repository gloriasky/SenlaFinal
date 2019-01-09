package volodko.ksenia.dao.network;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import volodko.ksenia.dao.AbstractDao;
import volodko.ksenia.interfaces.dao.network.IForumMessagesDao;
import volodko.ksenia.model.network.Forum;
import volodko.ksenia.model.network.ForumMessage;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class ForumMessagesDao extends AbstractDao implements IForumMessagesDao {

    public List<ForumMessage> selectLastWith(Forum forum){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ForumMessage> query = builder.createQuery(ForumMessage.class);
        Root<ForumMessage> root = query.from(ForumMessage.class);
        query.select(root).where(builder.equal(root.get("forum").get("id"),forum.getId()));
        Query<ForumMessage> q = session.createQuery(query);
        List<ForumMessage> messages = q.getResultList();
        return messages;
    }



    @Override
    public List<?> findByForum(Forum forum) {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ForumMessage> query = builder.createQuery(ForumMessage.class);
        Root<ForumMessage> root = query.from(ForumMessage.class);
        query.select(root).where(builder.equal(root.get("name"),forum.getName()));
        Query<ForumMessage> q = session.createQuery(query);
        List<ForumMessage> forums = q.getResultList();
        return forums;
    }


    @Override
    public List<?> list() {
        return null;
    }
}
