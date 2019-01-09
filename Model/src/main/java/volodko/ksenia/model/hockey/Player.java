package volodko.ksenia.model.hockey;


import org.springframework.beans.factory.annotation.Autowired;
import volodko.ksenia.enums.PlayerStatus;
import volodko.ksenia.enums.convertors.PlayerStatusConverter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "players")
public class Player implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player", fetch = FetchType.EAGER)
    private List<Number> number;
    @Column(name = "weight")
    private int weight;
    @Column(name = "height")
    private int height;
    @Convert(converter = PlayerStatusConverter.class)
    @Column(name = "work_status")
    private PlayerStatus playerStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team currentTeam;
    @Column(name = "home_town")
    private String homeTown;
    @Column(name = "home_country")
    private String homeCountry;

    public Player(){

    }

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Player(String firstName, String lastName, int age, List<Number> number, int weight, int height, Team currentTeam,PlayerStatus playerStatus, String homeTown, String homeCountry) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.number = number;
        this.weight = weight;
        this.height = height;
        this.playerStatus = playerStatus;
        this.currentTeam = currentTeam;
        this.homeTown = homeTown;
        this.homeCountry = homeCountry;
    }
    public Player(Integer id, String firstName, String lastName, int age,List<Number> number, int weight, int height, Team currentTeam,PlayerStatus playerStatus,String homeTown, String homeCountry) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.number = number;
        this.weight = weight;
        this.height = height;
        this.playerStatus = playerStatus;
        this.currentTeam=currentTeam;
        this.homeCountry = homeCountry;
        this.homeTown= homeTown;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Number> getNumber() {
        return number;
    }
    @Autowired
    public void setNumber(List<Number> number) {
        this.number = number;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }
    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }
    @Autowired
    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        else if(this.getClass()!=obj.getClass()){
            return false;
        }
        else{
            Player otherUser = (Player)obj;
            return this.getFirstName().equals(otherUser.getFirstName()) && this.getLastName().equals(otherUser.getLastName());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("№");
        stringBuilder.append(number.get(number.size()-1).getNumber());
        stringBuilder.append(":");
        stringBuilder.append(firstName);
        stringBuilder.append(" ");
        stringBuilder.append(lastName);
        return stringBuilder.toString();

    }
}
