package volodko.ksenia.interfaces.dao.network;

import volodko.ksenia.interfaces.dao.IDao;
import volodko.ksenia.model.network.Forum;
import volodko.ksenia.model.network.ForumMessage;


import java.util.List;

public interface IForumMessagesDao extends IDao {
     List<ForumMessage> selectLastWith(Forum forum);

     List<?> findByForum(Forum forum);
}
