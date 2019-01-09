package volodko.ksenia.services.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import volodko.ksenia.dao.network.ForumMessagesDao;
import volodko.ksenia.interfaces.dao.network.IForumMessagesDao;
import volodko.ksenia.interfaces.services.network.IForumMessagesService;
import volodko.ksenia.model.network.Forum;
import volodko.ksenia.model.network.ForumMessage;

import java.util.List;

@Transactional
@Service
public class ForumMessageService implements IForumMessagesService {
    @Autowired
    private IForumMessagesDao forumMessagesDao;

    public List<ForumMessage> getMessages(Forum forum){
        return forumMessagesDao.selectLastWith(forum);
    }

    public void sendMessage(ForumMessage forumMessage){
        forumMessagesDao.save(forumMessage);
    }
}
