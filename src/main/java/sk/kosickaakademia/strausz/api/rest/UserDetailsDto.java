package sk.kosickaakademia.strausz.api.rest;

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
    private Integer userId;


    @NotNull(message = "trainingId.cannot.be.null")
    private Integer trainingId;


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


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }


}
