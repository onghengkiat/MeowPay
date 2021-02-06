package meowpay.restcontroller.comment;

import com.sun.istack.NotNull;
import meowpay.restcontroller.claim.Claim;
import meowpay.restcontroller.meow.Meow;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @SequenceGenerator(name = "comment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    private int comment_id;

    @ManyToOne
    @JoinColumn(name="claim_id",nullable=false)
    private Claim claim;


    @ManyToOne
    @JoinColumn(name="meow_id",referencedColumnName = "meow_id",nullable=false)
    private Meow meow;

    @NotNull
    private Date time;
    @NotNull
    private String comment;

    public Comment() {
        this.time = new Date();
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public Claim getClaim() {
        return claim;
    }

    public Meow getMeow() {
        return meow;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public void setMeow(Meow meow) {
        this.meow = meow;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", claim=" + claim +
                ", meow=" + meow +
                ", time=" + time +
                ", comment='" + comment + '\'' +
                '}';
    }
}
