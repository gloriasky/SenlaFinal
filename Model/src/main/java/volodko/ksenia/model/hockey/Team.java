package volodko.ksenia.model.hockey;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity(name = "teams")
public class Team {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String name;
    @Column
    private String home_town;
    @Column
    private String home_country;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id")
    private Coach coach;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "currentTeam", fetch = FetchType.LAZY)
    private List<Player> players;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "homeTeam", fetch = FetchType.LAZY)
    private List<Game> homeGames;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "guestTeam", fetch = FetchType.LAZY)
    private List<Game> guestGames;

    public Team() {
    }

    public Team(String name, String home_town, String home_country, Coach coach) {
        this.name = name;
        this.home_town = home_town;
        this.home_country = home_country;
        this.coach = coach;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome_town() {
        return home_town;
    }

    public void setHome_town(String home_town) {
        this.home_town = home_town;
    }

    public String getHome_country() {
        return home_country;
    }

    public void setHome_country(String home_country) {
        this.home_country = home_country;
    }

    public Coach getCoach() {
        return coach;
    }
    @Autowired
    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<Game> getHomeGames() {
        return homeGames;
    }
    @Autowired
    public void setHomeGames(List<Game> homeGames) {
        this.homeGames = homeGames;
    }

    public List<Game> getGuestGames() {
        return guestGames;
    }
    @Autowired
    public void setGuestGames(List<Game> guestGames) {
        this.guestGames = guestGames;
    }

    public List<Player> getPlayers() {
        return players;
    }
    @Autowired
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Team: ");
        stringBuilder.append(name);
        stringBuilder.append("-");
        stringBuilder.append(home_town);
        stringBuilder.append(" ("+home_country+") ");
        stringBuilder.append(":");
        stringBuilder.append(coach);
        return stringBuilder.toString();
    }
}
