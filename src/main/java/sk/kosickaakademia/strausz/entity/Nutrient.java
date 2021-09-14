package sk.kosickaakademia.strausz.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "nutrient")
public class Nutrient {

    @Id
    private int id;

    private String name;

    private String unit_name;

    private String nutrient_nbr;

    private String rank;

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

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getNutrient_nbr() {
        return nutrient_nbr;
    }

    public void setNutrient_nbr(String nutrient_nbr) {
        this.nutrient_nbr = nutrient_nbr;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Nutrient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit_name='" + unit_name + '\'' +
                ", nutrient_nbr='" + nutrient_nbr + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
