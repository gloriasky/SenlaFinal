package volodko.ksenia.services.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import volodko.ksenia.dao.network.MessagesDao;
import volodko.ksenia.interfaces.dao.network.IMessagesDao;
import volodko.ksenia.interfaces.services.network.IMessagesService;
import volodko.ksenia.model.network.*;

import java.util.List;

@Transactional
@Service
public class MessageService  implements IMessagesService {

    @Autowired
    private IMessagesDao messagesDao;

    public void sendPrivateMessage(Message message){
        messagesDao.save(message);
    }

    public List<Message> getReceivedMessages(User user){
        return messagesDao.selectReceivedNextWith(user,10);
    }

    public List<Message> getSentMessages(User user){
        return messagesDao.selectSentNextWith(user, 10);
    }
}
