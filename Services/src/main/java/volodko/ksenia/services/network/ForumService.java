package volodko.ksenia.services.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import volodko.ksenia.dao.network.ForumDao;
import volodko.ksenia.interfaces.dao.network.IForumDao;
import volodko.ksenia.interfaces.services.network.IForumService;
import volodko.ksenia.model.network.Forum;
import volodko.ksenia.model.network.User;

@Transactional
@Service
public class ForumService implements IForumService {
    @Autowired
    private IForumDao forumDao;

    public void createForum(Forum forum){
        forumDao.save(forum);
    }
}
