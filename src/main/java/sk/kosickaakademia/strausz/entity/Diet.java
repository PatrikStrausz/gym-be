package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;
import java.util.Set;

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


    @ManyToMany
    @JoinTable(
            name = "food_diet",
            joinColumns = @JoinColumn(name = "diet_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id"))
    private Set<Food> foodSet;


    @OneToOne(mappedBy = "diet")
    private UserDetails userDetails;

    public Diet() {
    }

    public Diet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Diet(String name) {
        this.name = name;
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

    public Set<Food> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<Food> foodSet) {
        this.foodSet = foodSet;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
