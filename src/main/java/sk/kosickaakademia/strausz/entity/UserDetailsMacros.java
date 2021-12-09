package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "user_details_macros")
public class UserDetailsMacros {

    @Id
    @SequenceGenerator(
            name = "user_details_macros_sequence",
            sequenceName = "user_details_macros_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_details_macros_sequence"
    )
    @Column(name = "id")
    private int id;

    @Column(name = "user_details_id")
    private Integer userDetailsId;

    @Column(name = "macros_id")
    private Integer macrosId;

    @Column(name = "total_amount")
    private double totalAmount;

    public UserDetailsMacros() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(Integer userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public Integer getMacrosId() {
        return macrosId;
    }

    public void setMacrosId(Integer macrosId) {
        this.macrosId = macrosId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
