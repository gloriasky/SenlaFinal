package volodko.ksenia.interfaces.services.hockey;

import volodko.ksenia.model.hockey.Player;
import volodko.ksenia.model.hockey.Team;

import java.util.List;

public interface IPlayerService {
     List<Player> getPlayersOfTheTeam(Team team);
     Player getPlayerInfo(Player player);
     void updatePlayerInfo(Player player);
     void addNewPlayer(Player player);
}
