package meowpay.restcontroller.claim;

import com.sun.istack.NotNull;
import meowpay.restcontroller.meow.Meow;

import javax.persistence.*;

@Entity
public class Claim {
    @Id
    @SequenceGenerator(name = "claim_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "claim_seq")
    private int claim_id;

    @ManyToOne
    @JoinColumn(name="meow_id",nullable=false)
    private Meow meow;
    @NotNull
    private String description;
    @NotNull
    private int total_amount;
    @NotNull
    private int status;

    public Claim() {
    }

    public int getClaim_id() {
        return claim_id;
    }

    public void setClaim_id(int claim_id) {
        this.claim_id = claim_id;
    }

    public Meow getMeow() {
        return meow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claim_id=" + claim_id +
                ", meow=" + meow +
                ", description='" + description + '\'' +
                ", total_amount=" + total_amount +
                ", status=" + status +
                '}';
    }
}
