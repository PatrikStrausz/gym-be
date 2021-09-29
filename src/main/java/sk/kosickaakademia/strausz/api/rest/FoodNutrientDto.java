package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class FoodNutrientDto {

    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "fdcId.cannot.be.null")
    private int fdcId;

    @NotNull(message = "nutrientId.cannot.be.null")
    private int nutrientId;

    @NotNull(message = "amount.cannot.be.null")
    private double amount;

    public FoodNutrientDto(int id, int fdcId, int nutrientId, double amount) {
        this.id = id;
        this.fdcId = fdcId;
        this.nutrientId = nutrientId;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFdcId() {
        return fdcId;
    }

    public void setFdcId(int fdcId) {
        this.fdcId = fdcId;
    }

    public int getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(int nutrientId) {
        this.nutrientId = nutrientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
