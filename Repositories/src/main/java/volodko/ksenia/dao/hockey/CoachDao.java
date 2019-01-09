package volodko.ksenia.dao.hockey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import volodko.ksenia.dao.AbstractDao;
import volodko.ksenia.interfaces.dao.hockey.ICoachDao;
import volodko.ksenia.model.hockey.Coach;
import volodko.ksenia.model.hockey.Team;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CoachDao extends AbstractDao implements ICoachDao {
    private SessionFactory sessionFactory;

    private CoachDao(){
    }

    @Override
    public List<?> list() {
        @SuppressWarnings("unchecked")
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Coach> query = builder.createQuery(Coach.class);
        Root<Coach> root = query.from(Coach.class);
        query.select(root);
        Query<Coach> q = session.createQuery(query);
        List<Coach> coaches = q.getResultList();
        session.close();
        return coaches;
    }
    public List<Coach> getCoachesOfTheTeam(Team team){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Coach> query = builder.createQuery(Coach.class);
        List<Coach> playersOfTheTeam = null;
        if (query != null) {
            Root<Coach> coaches = query.from(Coach.class);
            Join<Coach, Team> teamPlayers = coaches.join("currentTeam");
            query.where(builder.equal(coaches.get("currentTeam").get("name"), team.getName()));
            query.select(coaches);
            TypedQuery<Coach> q = session.createQuery(query);
            playersOfTheTeam = q.getResultList();
        }
        session.close();
        return playersOfTheTeam;
    }

}
