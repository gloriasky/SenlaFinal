package volodko.ksenia.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import volodko.ksenia.facade.App;
import volodko.ksenia.model.hockey.*;
import volodko.ksenia.model.hockey.Number;
import volodko.ksenia.model.network.*;


@Configuration
public class ModelConfigs {

    @Bean
    @Lazy
    public App app(){
        return new App();
    }

    @Bean @Scope("prototype")
    @Lazy
    public User user(){
        return new User();
    }
    @Bean @Scope("prototype")
    @Lazy
    public Login login(){
        return new Login();
    }
    @Bean @Scope("prototype")
    @Lazy
    public Forum forum(){
        return new Forum();
    }
    @Bean @Scope("prototype")
    @Lazy
    public ForumMessage forumMessage(){
        return new ForumMessage();
    }
    @Bean @Scope("prototype")
    @Lazy
    public Message message(){
        return new Message();
    }
    @Bean @Scope("prototype")
    @Lazy
    public Coach coach(){
        return new Coach();
    }
    @Bean @Scope("prototype")@Lazy
    public Game game(){
        return new Game();
    }
    @Bean @Scope("prototype")@Lazy
    public GameResult gameResult(){
        return new GameResult();
    }
    @Bean @Scope("prototype")@Lazy
    public Goal goal(){
        return new Goal();
    }
    @Bean @Scope("prototype")@Lazy
    public Number number(){
        return new Number();
    }
    @Bean @Scope("prototype")@Lazy
    public Player player(){
        return new Player();
    }
    @Bean @Scope("prototype")@Lazy
    public Referee referee(){
        return new Referee();
    }
    @Bean @Scope("prototype")@Lazy
    public RefereeRecord refereeRecord(){
        return new RefereeRecord();
    }
    @Bean @Scope("prototype")@Lazy
    public Team team(){
        return new Team();
    }

}