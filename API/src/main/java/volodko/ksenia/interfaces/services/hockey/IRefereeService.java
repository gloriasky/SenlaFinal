package volodko.ksenia.interfaces.services.hockey;

import volodko.ksenia.model.hockey.Game;
import volodko.ksenia.model.hockey.Referee;
import volodko.ksenia.model.hockey.RefereeRecord;

import java.util.List;

public interface IRefereeService {
     List<Referee> getRefereesOfTheGame(Game game);

     void addRefereeRecord(RefereeRecord refereeRecord);
     void updateRefereeRecord(RefereeRecord refereeRecord);
     void saveReferee(Referee referee);
     void updateReferee(Referee referee);
}
