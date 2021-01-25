package meowpay.restcontroller.transaction;

import com.sun.istack.NotNull;
import meowpay.restcontroller.claim.Claim;
import meowpay.restcontroller.meow.Meow;
import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @SequenceGenerator(name = "transaction_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    private int transaction_id;

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

    //1 stands for processing, 2 stands for approved
    @NotNull
    private int status;

    public Transaction() {
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", claim=" + claim +
                ", creditor=" + creditor +
                ", debitor=" + debitor +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
