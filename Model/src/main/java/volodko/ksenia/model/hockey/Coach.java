package volodko.ksenia.model.hockey;

import org.springframework.beans.factory.annotation.Autowired;
import volodko.ksenia.enums.CoachStatus;
import volodko.ksenia.enums.convertors.CoachStatusConverter;



import javax.persistence.*;
import java.util.List;

@Entity(name = "coaches")
public class Coach{
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "work_status")
    @Convert(converter = CoachStatusConverter.class)
    private CoachStatus coachStatus;
    @Column(name = "home_town")
    private String homeTown;
    @Column(name = "home_country")
    private String homeCountry;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "coach")
    private List<Team> currentTeam;

    public Coach(){

    }

    public Coach(String firstName, String lastName, CoachStatus coachStatus, String homeTown, String homeCountry, List<Team> currentTeam) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.coachStatus = coachStatus;
        this.homeTown = homeTown;
        this.homeCountry = homeCountry;
        this.currentTeam = currentTeam;
    }
    public Coach(Integer id,String firstName, String lastName, CoachStatus coachStatus, String homeTown, String homeCountry, List<Team> currentTeam) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.coachStatus = coachStatus;
        this.homeTown = homeTown;
        this.homeCountry = homeCountry;
        this.currentTeam = currentTeam;
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

    public CoachStatus getCoachStatus() {
        return coachStatus;
    }

    public void setCoachStatus(CoachStatus coachStatus) {
        this.coachStatus = coachStatus;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        this.homeCountry = homeCountry;
    }

    public List<Team> getCurrentTeam() {
        return currentTeam;
    }
    @Autowired
    public void setCurrentTeam(List<Team> currentTeam) {
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
            Coach otherUser = (Coach)obj;
            return this.getFirstName().equals(otherUser.getFirstName()) && this.getLastName().equals(otherUser.getLastName());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("First name: ");
        stringBuilder.append(firstName);
        stringBuilder.append(", Last name: ");
        stringBuilder.append(lastName);
        return stringBuilder.toString();
    }
}
