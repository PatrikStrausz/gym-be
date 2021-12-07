package sk.kosickaakademia.strausz.api.rest;

public class FoodListDto {


    private Long id;

    private String name;

    private int energyValue;

    private String details;

    private double protein;

    private double carbohydrates;

    private double sugars;

    private double fats;

    private double saturatedFattyAcids;

    private double transFattyAcids;

    private double monounsaturated;

    private double semiSaturated;

    private double cholesterol;

    private double fiber;

    private double salt;

    private double water;

    private double calcium;

    private double phe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(int energyValue) {
        this.energyValue = energyValue;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getSaturatedFattyAcids() {
        return saturatedFattyAcids;
    }

    public void setSaturatedFattyAcids(double saturatedFattyAcids) {
        this.saturatedFattyAcids = saturatedFattyAcids;
    }

    public double getTransFattyAcids() {
        return transFattyAcids;
    }

    public void setTransFattyAcids(double transFattyAcids) {
        this.transFattyAcids = transFattyAcids;
    }

    public double getMonounsaturated() {
        return monounsaturated;
    }

    public void setMonounsaturated(double monounsaturated) {
        this.monounsaturated = monounsaturated;
    }

    public double getSemiSaturated() {
        return semiSaturated;
    }

    public void setSemiSaturated(double semiSaturated) {
        this.semiSaturated = semiSaturated;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getFiber() {
        return fiber;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public double getSalt() {
        return salt;
    }

    public void setSalt(double salt) {
        this.salt = salt;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getPhe() {
        return phe;
    }

    public void setPhe(double phe) {
        this.phe = phe;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }
}
