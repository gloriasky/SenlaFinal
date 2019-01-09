package volodko.ksenia.interfaces.dao.hockey;

import volodko.ksenia.interfaces.dao.IDao;
import volodko.ksenia.model.hockey.Coach;
import volodko.ksenia.model.hockey.Game;
import volodko.ksenia.model.hockey.Team;

import java.util.List;

public interface ICoachDao extends IDao {

     List<Coach> getCoachesOfTheTeam(Team team);
}
