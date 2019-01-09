package volodko.ksenia.dao.hockey;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import volodko.ksenia.dao.AbstractDao;
import volodko.ksenia.interfaces.dao.hockey.IRefereeDao;
import volodko.ksenia.model.hockey.Game;
import volodko.ksenia.model.hockey.Referee;
import volodko.ksenia.model.hockey.RefereeRecord;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class RefereeDao extends AbstractDao implements IRefereeDao {
    @Override
    public List<?> list() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Referee> query = builder.createQuery(Referee.class);
        Root<Referee> root = query.from(Referee.class);
        query.select(root);
        Query<Referee> q = session.createQuery(query);
        List<Referee> referees = q.getResultList();
        session.close();
        return referees;
    }

    public List<Referee> getRefereesOfTheGame(Game game){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<RefereeRecord> query = builder.createQuery(RefereeRecord.class);
        List<RefereeRecord> referees = null;
        if (query != null) {
            Root<RefereeRecord> recordRoot = query.from(RefereeRecord.class);
            Join<RefereeRecord, Game> theReferees = recordRoot.join("game");
            query.where(builder.equal(recordRoot.get("game").get("date"), game.getGameDate()))
                    .where(builder.equal(recordRoot.get("game").get("homeTeam").get("name"),game.getHomeTeam().getName()));
            query.select(recordRoot);
            TypedQuery<RefereeRecord> q = session.createQuery(query);
            referees = q.getResultList();
        }
        session.close();
        return referees.get(0).getReferees();
    }
}
