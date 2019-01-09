package volodko.ksenia.services.hockey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import volodko.ksenia.dao.hockey.CoachDao;
import volodko.ksenia.interfaces.dao.hockey.ICoachDao;
import volodko.ksenia.interfaces.services.hockey.ICoachService;
import volodko.ksenia.model.hockey.Coach;
import volodko.ksenia.model.hockey.Team;

import java.util.List;



@Service
public class CoachService implements ICoachService {

    private ICoachDao coachDao;

    @Autowired
    private CoachService(CoachDao coachDao) {
        this.coachDao = coachDao;
    }

    public List<Coach> getCoachesOfTheTeam(Team team){
        return coachDao.getCoachesOfTheTeam(team);
    }
    @Transactional
    public void save(Coach coach){
        coachDao.save(coach);
    }
    @Transactional
    public void update(Coach coach){
        coachDao.save(coach);
    }

}
