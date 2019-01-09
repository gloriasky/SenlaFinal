package volodko.ksenia.model.network;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;


import javax.persistence.*;
import java.util.List;


@Entity(name = "users")
public class User{
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private Login loginInformation;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sender", fetch = FetchType.LAZY)
    private List<Message> sentMessages;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "message_history",
            joinColumns = {@JoinColumn(name = "receiver_id")},
            inverseJoinColumns = {@JoinColumn(name = "message_id")})
    private List<Message> receivedMessages;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "creator", fetch = FetchType.LAZY)
    private List<Forum> forums;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "friends_history",
            joinColumns = {@JoinColumn(name = "first_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "second_user_id")})
    private List<User> friends;
    public User(){

    }
    public User getUser(){
        return new User();
    }
    public User(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Login getLoginInformation() {
        return loginInformation;
    }
    @Autowired
    public void setLoginInformation(Login loginInformation) {
        this.loginInformation = loginInformation;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }
    @Autowired
    @Lazy
    public void setSentMessages(List<Message> messages) {
        this.sentMessages = messages;
    }

    public List<Forum> getForums() {
        return forums;
    }
    @Autowired
    @Lazy
    public void setForums(List<Forum> forums) {
        this.forums = forums;
    }


    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.first_name);
        stringBuilder.append(" ");
        stringBuilder.append(this.last_name);
        return stringBuilder.toString();
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
            User otherUser = (User)obj;
            return this.getFirst_name().equals(otherUser.getFirst_name()) && this.getLast_name().equals(otherUser.getLast_name());
        }
    }

    @Override
    public int hashCode() {
        return getLast_name().hashCode()+getFirst_name().hashCode();
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
