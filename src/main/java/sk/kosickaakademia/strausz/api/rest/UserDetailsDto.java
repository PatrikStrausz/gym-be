package sk.kosickaakademia.strausz.api.rest;

import sk.kosickaakademia.strausz.entity.Diet;
import sk.kosickaakademia.strausz.entity.Training;
import sk.kosickaakademia.strausz.entity.User;

import javax.validation.constraints.NotNull;

public class UserDetailsDto {


    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "firstname.cannot.be.null")
    private String firstname;

    @NotNull(message = "lastname.cannot.be.null")
    private String lastname;

    @NotNull(message = "height.cannot.be.null")
    private int height;

    @NotNull(message = "weight.cannot.be.null")
    private int weight;

    @NotNull(message = "age.cannot.be.null")
    private int age;

    @NotNull(message = "goal.cannot.be.null")
    private String goal;


    @NotNull(message = "userId.cannot.be.null")
    private User user;


    @NotNull(message = "trainingId.cannot.be.null")
    private Training training;

    @NotNull(message = "dietId.cannot.be.null")
    private Diet diet;

    public UserDetailsDto(int id, String firstname, String lastname, int height, int weight, int age, String goal, User user, Training training, Diet diet) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.goal = goal;
        this.user = user;
        this.training = training;
        this.diet = diet;
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

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }
}
