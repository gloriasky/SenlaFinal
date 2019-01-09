package volodko.ksenia.interfaces.dao.network;

import volodko.ksenia.interfaces.dao.IDao;
import volodko.ksenia.model.network.User;

public interface IUserDao extends IDao {
    User findNecessaryUser(User user);
}
