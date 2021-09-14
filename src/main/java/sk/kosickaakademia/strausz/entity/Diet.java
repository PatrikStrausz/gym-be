package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "diet")
public class Diet {

    @Id
    @SequenceGenerator(
            name = "diet_sequence",
            sequenceName = "diet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "diet_sequence"
    )
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "food_id")
    private int foodId;

    public Diet() { }

    public Diet(String name, int foodId) {
        this.name = name;
        this.foodId = foodId;
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

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
