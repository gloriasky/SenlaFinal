package volodko.ksenia.model.hockey;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name = "numbers")
public class Number{
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;
    @Column(name = "number")
    private Integer number;

    public Number(){

    }

    public Number(Player player, Integer number) {
        this.player = player;
        this.number = number;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
