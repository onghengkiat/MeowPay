package meowpay.restcontroller.meow;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Meow {
    @Id
    @SequenceGenerator(name = "meow_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meow_seq")
    private int meow_id;
    @NotNull
    private String name;
    @NotNull
    private String phone;
    @NotNull
    private int balance;

    @NotNull
    private Date time;
    public Meow(){
        this.time = new Date();
    }

    public Meow(int meow_id){
        this.meow_id = meow_id;
    }

    public int getMeow_id() {
        return meow_id;
    }

    public void setMeow_id(int meow_id) {
        this.meow_id = meow_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Meow{" +
                "meow_id=" + meow_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }
}
