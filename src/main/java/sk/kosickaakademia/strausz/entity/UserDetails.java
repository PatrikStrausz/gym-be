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
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @Column(name = "age")
    private int age;

    @Column(name = "goal")
    private String goal;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "training_id")
    private int trainingId;

    @Column(name = "diet_id")
    private int dietId;


    public UserDetails() {
    }

    public UserDetails(String firstname, String lastname, int height, int weight, int age, String goal, int userId, int trainingId, int dietId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.goal = goal;
        this.userId = userId;
        this.trainingId = trainingId;
        this.dietId = dietId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public int getDietId() {
        return dietId;
    }

    public void setDietId(int dietId) {
        this.dietId = dietId;
    }
}
