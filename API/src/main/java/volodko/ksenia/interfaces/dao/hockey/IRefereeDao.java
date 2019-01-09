package volodko.ksenia.interfaces.dao.hockey;

import volodko.ksenia.interfaces.dao.IDao;
import volodko.ksenia.model.hockey.Game;
import volodko.ksenia.model.hockey.Referee;
import java.util.List;

public interface IRefereeDao extends IDao {

    public List<Referee> getRefereesOfTheGame(Game game);
}
