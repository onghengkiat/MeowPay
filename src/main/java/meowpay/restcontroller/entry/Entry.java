package meowpay.restcontroller.entry;

import com.sun.istack.NotNull;
import meowpay.restcontroller.claim.Claim;
import meowpay.restcontroller.meow.Meow;

import javax.persistence.*;

@Entity
public class Entry {
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

    public Entry() {
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
                ", claim=" + claim +
                ", creditor=" + creditor +
                ", debitor=" + debitor +
                ", amount=" + amount +
                '}';
    }
}