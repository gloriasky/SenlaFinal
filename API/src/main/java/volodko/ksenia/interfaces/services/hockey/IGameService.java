package volodko.ksenia.interfaces.services.hockey;

import volodko.ksenia.enums.GameStatus;
import volodko.ksenia.model.hockey.Game;

import java.util.Date;
import java.util.List;

public interface IGameService {
     List<Game> getSchedule(Date date);
     List<Game> getListOfGames();
     List<Game> getGameInfo(GameStatus gameStatus);
     void updateGameInfo(Game game);
     void addNewGame(Game game);
}
