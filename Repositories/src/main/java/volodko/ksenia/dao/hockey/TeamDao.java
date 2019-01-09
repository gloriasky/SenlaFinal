package volodko.ksenia.dao.hockey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import volodko.ksenia.dao.AbstractDao;
import volodko.ksenia.interfaces.dao.hockey.ITeamDao;
import volodko.ksenia.model.hockey.Team;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
@Lazy
public class TeamDao extends AbstractDao implements ITeamDao {
    private SessionFactory sessionFactory;

    public TeamDao(){

    }

    @Override
    public List<?> list() {
        @SuppressWarnings("unchecked")
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Team> query = builder.createQuery(Team.class);
        Root<Team> root = query.from(Team.class);
        query.select(root);
        Query<Team> q = session.createQuery(query);
        List<Team> teams = q.getResultList();
        return teams;
    }

    public Team getTeamInfo(Team team){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Team> query = builder.createQuery(Team.class);
        Root<Team> root = query.from(Team.class);
        query.select(root).where(builder.equal(root.get("name"), team.getName()));
        Query<Team> q = session.createQuery(query);
        List<Team> teams = q.getResultList();
        session.close();
        return teams.get(0);
    }
}
