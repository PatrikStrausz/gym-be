package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class FoodDietDto {

    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "foodId.cannot.be.null")
    private int foodId;

    @NotNull(message = "dietId.cannot.be.null")
    private int dietId;

    public FoodDietDto(int id, int foodId, int dietId) {
        this.id = id;
        this.foodId = foodId;
        this.dietId = dietId;
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

    public int getDietId() {
        return dietId;
    }

    public void setDietId(int dietId) {
        this.dietId = dietId;
    }
}
