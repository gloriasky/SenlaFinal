package volodko.ksenia.model.network;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name = "login_information")
public class Login{
    @Column
    @Id
    private String login;
    @Column(name = "user_password")
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    public Login(){

    }

    public Login(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
