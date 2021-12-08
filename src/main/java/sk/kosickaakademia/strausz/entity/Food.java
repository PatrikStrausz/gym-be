package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "food")
public class Food {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "energy_value")
    private int energyValue;

    @Column(name = "details")
    private String details;

    @Column(name = "protein")
    private double protein;

    @Column(name = "carbohydrates")
    private double carbohydrates;

    @Column(name = "sugars")
    private double sugars;

    @Column(name = "fats")
    private double fats;

    @Column(name = "saturated_fatty_acids")
    private double saturatedFattyAcids;

    @Column(name = "trans_fatty_acids")
    private double transFattyAcids;

    @Column(name = "monounsaturated")
    private double monounsaturated;

    @Column(name = "semi_saturated")
    private double semiSaturated;

    @Column(name = "cholesterol")
    private double cholesterol;

    @Column(name = "fiber")
    private double fiber;

    @Column(name = "salt")
    private double salt;

    @Column(name = "water")
    private double water;

    @Column(name = "calcium")
    private double calcium;

    @Column(name = "phe")
    private double phe;


    @ManyToMany(mappedBy = "foodSet", fetch = FetchType.EAGER)
    private Set<UserDetails> foodSet;


    @ManyToMany
    @JoinTable(
            name = "food_vitamin",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "vitamin_id"))
    private Set<Vitamin> vitaminSet;

    @ManyToMany
    @JoinTable(
            name = "food_mineral",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "mineral_id"))
    private Set<Mineral> mineralSet;


    public Food() {

    }

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

    public void setSemi_saturated(double semiSaturated) {
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


    public Set<Vitamin> getVitaminSet() {
        return vitaminSet;
    }

    public void setVitaminSet(Set<Vitamin> vitaminSet) {
        this.vitaminSet = vitaminSet;
    }

    public Set<Mineral> getMineralSet() {
        return mineralSet;
    }

    public void setMineralSet(Set<Mineral> mineralSet) {
        this.mineralSet = mineralSet;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    public Set<UserDetails> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<UserDetails> foodSet) {
        this.foodSet = foodSet;
    }
}
