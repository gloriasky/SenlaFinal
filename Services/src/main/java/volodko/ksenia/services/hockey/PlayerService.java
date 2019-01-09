package volodko.ksenia.services.hockey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import volodko.ksenia.dao.hockey.PlayerDao;
import volodko.ksenia.interfaces.dao.hockey.IPlayerDao;
import volodko.ksenia.interfaces.services.hockey.IPlayerService;
import volodko.ksenia.model.hockey.Player;
import volodko.ksenia.model.hockey.Team;

import java.util.List;

@Transactional
@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerDao playerDao;

    public List<Player> getPlayersOfTheTeam(Team team){
        return playerDao.getPlayersOfTheTeam(team);
    }
    public Player getPlayerInfo(Player player){
        return playerDao.getPlayerInfo(player);
    }
    public void updatePlayerInfo(Player player){
        playerDao.update(player);
    }
    public void addNewPlayer(Player player){
        playerDao.save(player);
    }
}
