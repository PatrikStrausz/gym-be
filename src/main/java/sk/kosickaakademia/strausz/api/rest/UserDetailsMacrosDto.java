package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class UserDetailsMacrosDto {


    private int id;

    @NotNull(message = "userDetailsId.cannot.be.null")
    private Integer userDetailsId;
    @NotNull(message = "macrosId.cannot.be.null")
    private Integer macrosId;
    @NotNull(message = "totalAmount.cannot.be.null")
    private double totalAmount;

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
