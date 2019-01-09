package volodko.ksenia.interfaces.services.network;

import volodko.ksenia.model.network.Forum;
import volodko.ksenia.model.network.ForumMessage;

import java.util.List;

public interface IForumMessagesService{
     List<ForumMessage> getMessages(Forum forum);

     void sendMessage(ForumMessage forumMessage);
}
