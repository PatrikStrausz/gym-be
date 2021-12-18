package sk.kosickaakademia.strausz.entity;


import javax.persistence.*;
import java.util.ArrayList;

@Entity(name = "user_details_training")
public class UserDetailsTraining {

    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "user_details_training_sequence",
            sequenceName = "user_details_training_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_details_training_sequence"
    )
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "training_id")
    private Integer trainingId;

    @Column(name = "user_details_id")
    private Integer userDetailsId;


    @Column(name = "sets")
    private Integer sets;

    @Column(name = "reps")
    private Integer reps;

    @Column(name = "weight")
    private ArrayList<Integer> weight;

    @Column(name = "date")
    private String date;

    public UserDetailsTraining() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public Integer getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(Integer userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public ArrayList<Integer> getWeight() {
        return weight;
    }

    public void setWeight(ArrayList<Integer> weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
