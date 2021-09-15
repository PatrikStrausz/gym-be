package sk.kosickaakademia.strausz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity(name = "nutrient")
public class Nutrient {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "nutrient_nbr")
    private String nutrientNbr;

    @Column(name = "rank")
    private String rank;


    @ManyToMany(mappedBy = "nutrientSet")
    private Set<Food> foodSet;

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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getNutrientNbr() {
        return nutrientNbr;
    }

    public void setNutrientNbr(String nutrientNbr) {
        this.nutrientNbr = nutrientNbr;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Set<Food> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<Food> foodSet) {
        this.foodSet = foodSet;
    }
}
