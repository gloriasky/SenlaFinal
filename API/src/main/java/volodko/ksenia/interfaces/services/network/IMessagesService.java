package volodko.ksenia.interfaces.services.network;

import volodko.ksenia.model.network.Message;
import volodko.ksenia.model.network.User;

import java.util.List;

public interface IMessagesService {
     void sendPrivateMessage(Message message);

     List<Message> getReceivedMessages(User user);

     List<Message> getSentMessages(User user);
}
