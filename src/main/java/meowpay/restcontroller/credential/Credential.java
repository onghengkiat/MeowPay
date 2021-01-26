package meowpay.restcontroller.credential;

import com.sun.istack.NotNull;
import meowpay.restcontroller.meow.Meow;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Credential {
    @Id
    private String username;

    @OneToOne
    @JoinColumn(name="meow_id",nullable=false)
    private Meow meow;

    @NotNull
    private String password;

    @NotNull
    private Date time;

    public Credential() {
        this.time = new Date();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Meow getMeow() {
        return meow;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credential{" +
                "username='" + username + '\'' +
                ", meow=" + meow +
                ", password='" + password + '\'' +
                '}';
    }
}
