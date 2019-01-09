package volodko.ksenia.facade;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import volodko.ksenia.enums.GameStatus;
import volodko.ksenia.interfaces.services.hockey.*;
import volodko.ksenia.interfaces.services.network.IForumMessagesService;
import volodko.ksenia.interfaces.services.network.IForumService;
import volodko.ksenia.interfaces.services.network.IMessagesService;
import volodko.ksenia.interfaces.services.network.IUserService;
import volodko.ksenia.model.hockey.Coach;
import volodko.ksenia.model.hockey.Game;
import volodko.ksenia.model.hockey.Player;
import volodko.ksenia.model.hockey.Team;
import volodko.ksenia.model.network.*;
import volodko.ksenia.services.hockey.*;
import volodko.ksenia.services.network.ForumMessageService;
import volodko.ksenia.services.network.ForumService;
import volodko.ksenia.services.network.MessageService;
import volodko.ksenia.services.network.UserService;

import java.util.Date;
import java.util.List;

public class App {

    @Autowired
    @Qualifier("userService")
    private IUserService userService;
    @Autowired
    private ICoachService coachService;
    @Autowired
    private IGameService gameService;
    @Autowired
    private IPlayerService playerService;
    @Autowired
    private IRefereeService refereeService;
    @Autowired
    private ITeamService teamService;
    @Autowired
    private IForumMessagesService forumMessageService;
    @Autowired
    private IForumService forumService;
    @Autowired
    private IMessagesService messageService;


    private final static Logger logger = Logger.getLogger(App.class);

    public boolean registration(User user){
        try {
            userService.addUser(user);
            return true;
        }catch (Exception ex){
            logger.error(ex);
            ex.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
    }
    public  User checkIn(User user){
        try {
            return userService.checkIn(user);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
    public void updateUser(User user){
        try {
            userService.updateUserInformation(user);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public List<Player> getPlayersOfTheTeam(Team team){
        try {
            return playerService.getPlayersOfTheTeam(team);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
    public Player getPlayerInfo(Player player){
        try {
            return playerService.getPlayerInfo(player);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
    public void updatePlayerInfo(Player player){
        try {
            playerService.updatePlayerInfo(player);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public List<Game> getListOfGames(){
        try {
            return gameService.getListOfGames();
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
    public List<Game> getGamesWithStatus(GameStatus gameStatus){
        try {
            return gameService.getGameInfo(gameStatus);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
    public void updateGameInfo(Game game){
        try {
            gameService.updateGameInfo(game);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public User getUserInfo(User user){
        try {
            return userService.getUserInfo();
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
    public void setFriendship(User user){
        try {
            userService.updateUserInformation(user);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public void deleteFriendship(User user){
        try {
            userService.updateUserInformation(user);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public List<Game> getSchedule(Date date){
        try {
            return gameService.getSchedule(date);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
    public void createForum(Forum forum){
        try {
            forumService.createForum(forum);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public void startSubscribtionToForum(User user){
        try {
            userService.updateUserInformation(user);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public void endSubscriptionToForum(User user){
        try {
            userService.updateUserInformation(user);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public void sendPrivateMessage(Message message){
        try {
            messageService.sendPrivateMessage(message);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public void sendPublicMessage(ForumMessage forumMessage){
        try {
            forumMessageService.sendMessage(forumMessage);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public Team  getTeamInfo(Team team){
        try {
            return teamService.getTeamInfo(team);
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
    public void updateCoachInfo(Coach coach){
        try {
            coachService.update(coach);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public void addNewGame(Game game){
        try {
            gameService.addNewGame(game);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
    public void addNewPlayer(Player player){
        try {
            playerService.addNewPlayer(player);
        }catch (Exception ex){
            logger.error(ex.getMessage());

        }
    }
}
