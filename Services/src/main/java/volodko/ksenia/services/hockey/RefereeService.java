package volodko.ksenia.services.hockey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import volodko.ksenia.dao.hockey.RefereeDao;
import volodko.ksenia.interfaces.dao.hockey.IRefereeDao;
import volodko.ksenia.interfaces.services.hockey.IRefereeService;
import volodko.ksenia.model.hockey.Game;
import volodko.ksenia.model.hockey.Referee;
import volodko.ksenia.model.hockey.RefereeRecord;

import java.util.List;

@Transactional
@Service
public class RefereeService implements IRefereeService {
    @Autowired
    private IRefereeDao refereeDao;

    public List<Referee> getRefereesOfTheGame(Game game){
        return refereeDao.getRefereesOfTheGame(game);
    }

    public void addRefereeRecord(RefereeRecord refereeRecord){
        refereeDao.save(refereeRecord);
    }
    public void updateRefereeRecord(RefereeRecord refereeRecord){
        refereeDao.update(refereeRecord);
    }
    public void saveReferee(Referee referee){
        refereeDao.save(referee);
    }
    public void updateReferee(Referee referee){
        refereeDao.update(referee);
    }
}
