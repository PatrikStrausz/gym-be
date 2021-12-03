package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "food_mineral")
public class FoodMineral {
    @Id
    @SequenceGenerator(
            name = "food_mineral_sequence",
            sequenceName = "food_mineral_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "food_mineral_sequence"
    )
    @Column(name = "id")
    private int id;

    @Column(name = "food_id")
    private Integer foodId;

    @Column(name = "mineral_id")
    private Integer mineralId;

    @ManyToMany(mappedBy = "mineralSet", fetch = FetchType.EAGER)
    private Set<Food> foodSet;


    public FoodMineral() {
    }

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

    public Integer getMineralId() {
        return mineralId;
    }

    public void setMineralId(Integer mineralId) {
        this.mineralId = mineralId;
    }

    public Set<Food> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<Food> foodSet) {
        this.foodSet = foodSet;
    }
}
