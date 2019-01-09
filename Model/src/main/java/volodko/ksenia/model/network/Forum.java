package volodko.ksenia.model.network;

import javax.persistence.*;
import java.util.List;

@Entity
public class Forum {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String theme;
    @Column
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",insertable=false,updatable=false)
    private User creator;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "forum", fetch = FetchType.LAZY )
    private List<ForumMessage> messages;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "forum_history",
            joinColumns = {@JoinColumn(name = "forum_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> followers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<ForumMessage> getMessages() {
        return  messages;
    }

    public void setMessages(List<ForumMessage> messages) {
        this.messages = messages;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
}
