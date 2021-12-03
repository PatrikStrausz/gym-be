package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "food_vitamin")
public class FoodVitamin {

    @Id
    @SequenceGenerator(
            name = "food_vitamin_sequence",
            sequenceName = "food_vitamin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "food_vitamin_sequence"
    )
    @Column(name = "id")
    private int id;

    @Column(name = "food_id")
    private Integer foodId;

    @Column(name = "vitamin_id")
    private Integer vitaminId;

    @ManyToMany(mappedBy = "vitaminSet", fetch = FetchType.EAGER)
    private Set<Food> foodSet;


    public FoodVitamin() {
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

    public Integer getVitaminId() {
        return vitaminId;
    }

    public void setVitaminId(Integer vitaminId) {
        this.vitaminId = vitaminId;
    }

    public Set<Food> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<Food> foodSet) {
        this.foodSet = foodSet;
    }
}
