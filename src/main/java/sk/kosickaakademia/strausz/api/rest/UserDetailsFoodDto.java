package sk.kosickaakademia.strausz.api.rest;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserDetailsFoodDto {

    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "foodId.cannot.be.null")
    private Integer foodId;

    @NotNull(message = "userDetailsId.cannot.be.null")
    private Integer userDetailsId;

    @NotNull(message = "amount.cannot.be.null")
    private double amount;

    @NotNull(message = "timeOfTheDay.cannot.be.null")
    private String timeOfTheDay;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    @NotNull(message = "date.cannot.be.null")
    private Date date;

    @NotNull(message = "foodName.cannot.be.null")
    private String foodName;

    @NotNull(message = "totalCalories.cannot.be.null")
    private double totalCalories;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(Integer userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTimeOfTheDay() {
        return timeOfTheDay;
    }

    public void setTimeOfTheDay(String timeOfTheDay) {
        this.timeOfTheDay = timeOfTheDay;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }
}
