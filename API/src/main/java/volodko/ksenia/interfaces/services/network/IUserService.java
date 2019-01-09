package volodko.ksenia.interfaces.services.network;

import volodko.ksenia.model.network.User;

public interface IUserService {
    User getUserInfo();
    User checkIn(User user);
    void updateUserInformation(User user);
    void addUser(User user);
}
