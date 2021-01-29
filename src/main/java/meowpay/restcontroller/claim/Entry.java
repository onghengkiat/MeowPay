package meowpay.restcontroller.claim;

import com.sun.istack.NotNull;
import meowpay.restcontroller.meow.Meow;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Entry implements Comparable<Entry>{
    @Id
    @SequenceGenerator(name = "entry_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry_seq")
    private int entry_id;

    @ManyToOne
    @JoinColumn(name="claim_id",nullable=false)
    private Claim claim;

    @ManyToOne
    @JoinColumn(name="creditor",referencedColumnName = "meow_id",nullable=false)
    private Meow creditor;

    @ManyToOne
    @JoinColumn(name="debitor",referencedColumnName = "meow_id",nullable=false)
    private Meow debitor;

    @NotNull
    private int amount;

    @NotNull
    private Date time;

    public Entry() {
        this.time = new Date();
    }

    public Entry(int entry_id) {
        this.entry_id = entry_id;
    }

    public Entry(Claim claim, Meow creditor, Meow debitor, int amount) {
        this.claim = claim;
        this.creditor = creditor;
        this.debitor = debitor;
        this.amount = amount;
        this.time = new Date();
    }

    public int getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(int entry_id) {
        this.entry_id = entry_id;
    }

    public Claim getClaim() {
        return claim;
    }

    public Meow getCreditor() {
        return creditor;
    }

    public Meow getDebitor() {
        return debitor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "entry_id=" + entry_id +
                ", claim=" + claim.getClaim_id() +
                ", creditor=" + creditor.getMeow_id() +
                ", debitor=" + debitor.getMeow_id() +
                ", amount=" + amount +
                '}';
    }

    @Override
    public int compareTo(Entry o) {
        return this.time.compareTo(o.time);
    }
}
