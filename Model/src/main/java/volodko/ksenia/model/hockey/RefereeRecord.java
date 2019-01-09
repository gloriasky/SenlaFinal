package volodko.ksenia.model.hockey;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "referee_records")
public class RefereeRecord {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "first_referee_id")
    private Referee firstReferee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "second_referee_id")
    private Referee secondReferee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "third_referee_id")
    private Referee thirdReferee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "forth_referee_id")
    private Referee forthReferee;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Referee> getReferees() {
        List<Referee> referees = new ArrayList<>();
        referees.add(firstReferee);
        referees.add(secondReferee);
        referees.add(thirdReferee);
        if(forthReferee!=null){
            referees.add(forthReferee);
        }
        return referees;
    }

    public void setReferees(List<Referee> referees) {
        this.firstReferee = referees.get(0);
        this.secondReferee = referees.get(1);
        this.thirdReferee = referees.get(2);
        if(referees.get(3)!=null){
            forthReferee = referees.get(3);
        }
    }
}
