package volodko.ksenia.model.hockey;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name = "goals")
public class Goal {
    @Id
    @GeneratedValue
    private Integer id;
    @JoinTable(name = "players",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "player_id")
    private Player player;


    public Goal(Integer id, Player player) {
        this.id = id;
        this.player = player;
    }

    public Goal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }
    @Autowired
    public void setPlayer(Player player) {
        this.player = player;
    }
}
