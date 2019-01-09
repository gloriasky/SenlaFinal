package volodko.ksenia.dao.hockey;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import volodko.ksenia.dao.AbstractDao;
import volodko.ksenia.interfaces.dao.hockey.IPlayerDao;
import volodko.ksenia.model.hockey.Player;
import volodko.ksenia.model.hockey.Team;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class PlayerDao extends AbstractDao implements IPlayerDao {

    public List<?> list() {
        @SuppressWarnings("unchecked")
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Player> query = builder.createQuery(Player.class);
        Root<Player> root = query.from(Player.class);
        query.select(root);
        Query<Player> q = session.createQuery(query);
        List<Player> players = q.getResultList();
        session.close();
        return players;
    }

    public List<Player> getPlayersOfTheTeam(Team team){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Player> query = builder.createQuery(Player.class);
        List<Player> playersOfTheTeam = null;
        if (query != null) {
            Root<Player> players = query.from(Player.class);
            Join<Player, Team> teamPlayers = players.join("currentTeam");
            query.where(builder.equal(players.get("currentTeam").get("name"), team.getName()));
            query.select(players);
            TypedQuery<Player> q = session.createQuery(query);
            playersOfTheTeam = q.getResultList();
        }
        session.close();
        return playersOfTheTeam;
    }
    public Player getPlayerInfo(Player player){
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Player> query = builder.createQuery(Player.class);
        List<Player> playersOfTheTeam = null;
        if (query != null) {
            Root<Player> players = query.from(Player.class);
            Join<Player, Number> thePlayers = players.join("currentTeam");
            query.where(builder.equal(players.get("number"), player.getNumber()))
            .where(builder.equal(players.get("firstName"),player.getFirstName()))
            .where(builder.equal(players.get("lastName"),player.getLastName()));
            query.select(players);
            TypedQuery<Player> q = session.createQuery(query);
            playersOfTheTeam = q.getResultList();
        }
        session.close();
        return playersOfTheTeam.get(0);
    }


}
