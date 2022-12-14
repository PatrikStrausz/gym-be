package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "user_details_food")
public class UserDetailsFood {

    @Id
    @SequenceGenerator(
            name = "user_details_food_sequence",
            sequenceName = "user_details_food_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_details_food_sequence"
    )
    @Column(name = "id")
    private int id;

    @Column(name = "food_id")
    private int foodId;

    @Column(name = "user_details_id")
    private int userDetailsId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "time_of_the_day")
    private String timeOfTheDay;


    @Column(name = "date")
    private String date;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "total_calories")
    private double totalCalories;


    public UserDetailsFood() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(int userDetailsId) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
