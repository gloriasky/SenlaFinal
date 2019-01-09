package volodko.ksenia.services.hockey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import volodko.ksenia.dao.hockey.TeamDao;
import volodko.ksenia.interfaces.dao.hockey.ITeamDao;
import volodko.ksenia.interfaces.services.hockey.ITeamService;
import volodko.ksenia.model.hockey.Team;


@Transactional
@Service
public class TeamService implements ITeamService {
    @Autowired
    private ITeamDao teamDao;

    public Team getTeamInfo(Team team){
         return teamDao.getTeamInfo(team);
    }
}
