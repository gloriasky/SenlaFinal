package volodko.ksenia.interfaces.dao.hockey;

import volodko.ksenia.interfaces.dao.IDao;
import volodko.ksenia.model.hockey.Player;
import volodko.ksenia.model.hockey.Team;
import java.util.List;

public interface IPlayerDao extends IDao {

    List<Player> getPlayersOfTheTeam(Team team);

    Player getPlayerInfo(Player player);
}
