package volodko.ksenia.dao.network;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import volodko.ksenia.dao.AbstractDao;
import volodko.ksenia.interfaces.dao.network.IForumDao;
import volodko.ksenia.model.network.Forum;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class ForumDao extends AbstractDao implements IForumDao {
    @Override
    public List<?> list() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Forum> query = builder.createQuery(Forum.class);
        Root<Forum> root = query.from(Forum.class);
        query.select(root);
        Query<Forum> q = session.createQuery(query);
        List<Forum> forums = q.getResultList();
        return forums;
    }
    public Forum findByName(Forum forum){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Forum> query = builder.createQuery(Forum.class);
        Root<Forum> root = query.from(Forum.class);
        query.select(root).where(builder.equal(root.get("name"),forum.getName()));
        Query<Forum> q = session.createQuery(query);
        Forum necessaryForum = q.getSingleResult();
        return necessaryForum;
    }

    public long selectCount(long groupId){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        Root<Forum> root = criteriaQuery.from(Forum.class);
        criteriaQuery.select(builder.count(root));
        Query<Long> query = session.createQuery(criteriaQuery);
        long count = query.getSingleResult();
        return count;
    }
}
