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
    private int id;

    private String name;

    private int food_id;

    public Diet() { }

    public Diet( String name, int food_id) {
        this.name = name;
        this.food_id = food_id;
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

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }
}
