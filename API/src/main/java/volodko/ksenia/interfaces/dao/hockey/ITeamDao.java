package volodko.ksenia.interfaces.dao.hockey;

import volodko.ksenia.interfaces.dao.IDao;
import volodko.ksenia.model.hockey.Team;


public interface ITeamDao extends IDao {

     Team getTeamInfo(Team team);
}
