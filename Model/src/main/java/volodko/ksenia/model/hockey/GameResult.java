package volodko.ksenia.model.hockey;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name = "results")
public class GameResult{
    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    private Game game;
    @Column
    private int homeTeamGoals;
    @Column
    private int guestTeamGoals;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }
    @Autowired
    public void setGame(Game game) {
        this.game = game;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getGuestTeamGoals() {
        return guestTeamGoals;
    }

    public void setGuestTeamGoals(int guestTeamGoals) {
        this.guestTeamGoals = guestTeamGoals;
    }
}
