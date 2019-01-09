package volodko.ksenia.interfaces.dao.network;

import volodko.ksenia.interfaces.dao.IDao;
import volodko.ksenia.model.network.Message;
import volodko.ksenia.model.network.User;
import java.util.List;

public interface IMessagesDao extends IDao {
     List<Message> selectReceivedNextWith(User user, int lot);

     List<Message> selectSentNextWith(User user, int lot);
}
