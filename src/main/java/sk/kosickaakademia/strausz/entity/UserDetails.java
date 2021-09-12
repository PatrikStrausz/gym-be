package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "user_details")
public class UserDetails {

    @Id
    @SequenceGenerator(
            name = "user_details_sequence",
            sequenceName = "user_details_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_details_sequence"
    )
    private int id;

    private String firstname;

    private String lastname;

    private int height;

    private int weight;

    private int age;

    private String goal;

    private int user_id;

    private int training_id;

    private int diet_id;


    public UserDetails() {
    }

    public UserDetails(String firstname, String lastname, int height, int weight, int age, String goal, int user_id, int training_id, int diet_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.goal = goal;
        this.user_id = user_id;
        this.training_id = training_id;
        this.diet_id = diet_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTraining_id() {
        return training_id;
    }

    public void setTraining_id(int training_id) {
        this.training_id = training_id;
    }

    public int getDiet_id() {
        return diet_id;
    }

    public void setDiet_id(int diet_id) {
        this.diet_id = diet_id;
    }
}
