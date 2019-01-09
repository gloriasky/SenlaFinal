package volodko.ksenia.model.hockey;

import org.springframework.beans.factory.annotation.Autowired;
import volodko.ksenia.enums.GameStatus;
import volodko.ksenia.enums.convertors.GameStatusConverter;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "games")
public class Game{
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;
    @ManyToOne
    @JoinColumn(name = "guest_team_id")
    private Team guestTeam;
    @Column(name = "game_date")
    private Date gameDate;
    @Convert(converter = GameStatusConverter.class)
    private GameStatus gameStatus;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "game",fetch = FetchType.LAZY)
    private GameResult gameResult;
    public Game() {
    }

    public Game(Team homeTeam, Team guestTeam, Date gameDate, GameStatus gameStatus) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.gameDate = gameDate;
        this.gameStatus = gameStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

}
