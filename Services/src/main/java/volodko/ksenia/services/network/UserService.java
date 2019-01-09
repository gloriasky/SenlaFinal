package volodko.ksenia.services.network;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import volodko.ksenia.dao.network.UserDao;
import volodko.ksenia.interfaces.dao.network.IUserDao;
import volodko.ksenia.interfaces.services.network.IUserService;
import volodko.ksenia.model.network.User;

@Service
@Qualifier(value = "userService")
public class UserService implements IUserService {
    private IUserDao userDao;

    @Autowired
    public UserService(@Qualifier("userDao") UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserInfo(){
        return null;
    }

    @Transactional
    public void addUser(User user){
        userDao.save(user);
    }

    @Transactional
    public User checkIn(User user) {
        return userDao.findNecessaryUser(user);
    }
    @Transactional
    public void updateUserInformation(User user){
        userDao.saveOrUpdate(user);
 }


}
