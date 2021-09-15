package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "food_diet")
public class FoodDiet {

    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "food_diet_sequence",
            sequenceName = "food_diet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "food_diet_sequence"
    )
    private int id;

    @Column(name = "food_id")
    private int foodId;

    @Column(name = "diet_id")
    private int dietId;



    public FoodDiet() {
    }

    public FoodDiet(int foodId, int dietId) {
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
