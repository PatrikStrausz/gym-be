package sk.kosickaakademia.strausz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity(name = "mineral")
public class Mineral {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "benefits")
    private String benefits;

    @Column(name = "recommended_amount")
    private String recommendedAmount;

    @Column(name = "upper_limit")
    private String upperLimit;

    @Column(name = "food_sources")
    private String foodSources;

    @ManyToMany(mappedBy = "mineralSet")
    private Set<Food> foodSet;

    public Mineral() {
    }


    public Mineral(String name, String benefits, String recommendedAmount, String upperLimit, String foodSources) {
        this.name = name;
        this.benefits = benefits;
        this.recommendedAmount = recommendedAmount;
        this.upperLimit = upperLimit;
        this.foodSources = foodSources;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getRecommendedAmount() {
        return recommendedAmount;
    }

    public void setRecommendedAmount(String recommendedAmount) {
        this.recommendedAmount = recommendedAmount;
    }

    public String getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(String upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getFoodSources() {
        return foodSources;
    }

    public void setFoodSources(String foodSources) {
        this.foodSources = foodSources;
    }

    public Set<Food> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<Food> foodSet) {
        this.foodSet = foodSet;
    }
}
