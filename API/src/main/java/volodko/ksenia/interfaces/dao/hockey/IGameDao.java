package volodko.ksenia.interfaces.dao.hockey;

import volodko.ksenia.enums.GameStatus;
import volodko.ksenia.interfaces.dao.IDao;
import volodko.ksenia.model.hockey.Game;

import java.util.Date;
import java.util.List;

public interface IGameDao extends IDao {


     List<Game> getGamesWithStatus(GameStatus gameStatus);

     List<Game> getSchedule(Date date);
}
