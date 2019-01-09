package volodko.ksenia.interfaces.services.hockey;

import volodko.ksenia.enums.GameStatus;
import volodko.ksenia.model.hockey.Coach;
import volodko.ksenia.model.hockey.Game;
import volodko.ksenia.model.hockey.Team;


import java.util.Date;
import java.util.List;

public interface ICoachService {
      List<Coach> getCoachesOfTheTeam(Team team);
      void save(Coach coach);
      void update(Coach coach);
}
