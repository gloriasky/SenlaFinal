package volodko.ksenia.dao.hockey;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import volodko.ksenia.dao.AbstractDao;
import volodko.ksenia.enums.GameStatus;
import volodko.ksenia.interfaces.dao.hockey.IGameDao;
import volodko.ksenia.model.hockey.Game;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Repository
public class GameDao extends AbstractDao implements IGameDao {
    @Override
    public List<?> list() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> query = builder.createQuery(Game.class);
        Root<Game> root = query.from(Game.class);
        query.select(root);
        Query<Game> q = session.createQuery(query);
        List<Game> games = q.getResultList();
        session.close();
        return games;
    }

    public List<Game> getGamesWithStatus(GameStatus gameStatus){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> query = builder.createQuery(Game.class);
        Root<Game> root = query.from(Game.class);
        query.select(root).where(builder.equal(root.get("status"), gameStatus));
        Query<Game> q = session.createQuery(query);
        List<Game> games = q.getResultList();
        session.close();
        return games;
    }


    public List<Game> getSchedule(Date date){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> query = builder.createQuery(Game.class);
        Root<Game> root = query.from(Game.class);
        query.select(root).where(builder.greaterThanOrEqualTo(root.get("game_date"),date));
        Query<Game> q = session.createQuery(query);
        List<Game> games = q.getResultList();
        return games;
    }

}
