package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;
import java.util.Set;

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

    @Column(name = "sex")
    private String sex;

    @Column(name = "activity")
    private String activity;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

    @ManyToMany
            (fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_details_food",
            joinColumns = @JoinColumn(name = "user_details_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id"))
    private Set<Food> foodSet;


    @ManyToMany
            (fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_details_macros",
            joinColumns = @JoinColumn(name = "user_details_id"),
            inverseJoinColumns = @JoinColumn(name = "macros_id"))
    private Set<Macros> macrosSet;

    public UserDetails() {
    }

    public UserDetails(int id, String firstname, String lastname, int height, int weight, int age,
                       String goal, String sex, String activity, User user, Training training) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.goal = goal;
        this.sex = sex;
        this.activity = activity;
        this.user = user;
        this.training = training;
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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Set<Food> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<Food> foodSet) {
        this.foodSet = foodSet;
    }

    public Set<Macros> getMacrosSet() {
        return macrosSet;
    }

    public void setMacrosSet(Set<Macros> macrosSet) {
        this.macrosSet = macrosSet;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }


}
