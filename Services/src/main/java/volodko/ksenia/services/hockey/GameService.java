package volodko.ksenia.services.hockey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import volodko.ksenia.dao.hockey.GameDao;
import volodko.ksenia.enums.GameStatus;
import volodko.ksenia.interfaces.dao.hockey.IGameDao;
import volodko.ksenia.interfaces.services.hockey.IGameService;
import volodko.ksenia.model.hockey.Game;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class GameService implements IGameService {
    @Autowired
    private IGameDao gameDao;

    public List<Game> getSchedule(Date date){
        return gameDao.getSchedule(date);
    }
    public List<Game> getListOfGames(){
        return (List<Game>) gameDao.list();
    }
    public List<Game> getGameInfo(GameStatus gameStatus){
        return gameDao.getGamesWithStatus(gameStatus);
    }
    public void updateGameInfo(Game game){
        gameDao.update(game);
    }
    public void addNewGame(Game game){ gameDao.save(game);}
}
