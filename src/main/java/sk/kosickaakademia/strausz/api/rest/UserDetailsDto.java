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


    private String sex;

    private String activity;


    private Integer userId;


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


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }


}
