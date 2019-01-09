package volodko.ksenia.interfaces.dao.network;

import volodko.ksenia.interfaces.dao.IDao;
import volodko.ksenia.model.network.Forum;



public interface IForumDao extends IDao {

     Forum findByName(Forum forum);
     long selectCount(long groupId);

}
