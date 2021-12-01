package sk.kosickaakademia.strausz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "mineral")
public class Mineral {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "function")
    private String function;

    @Column(name = "food_sources")
    private String foodSources;

    public Mineral() {
    }

    public Mineral(String name, String function, String foodSources) {
        this.name = name;
        this.function = function;
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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFoodSources() {
        return foodSources;
    }

    public void setFoodSources(String foodSources) {
        this.foodSources = foodSources;
    }
}
