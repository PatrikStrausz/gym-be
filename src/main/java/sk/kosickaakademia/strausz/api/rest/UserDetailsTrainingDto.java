package sk.kosickaakademia.strausz.api.rest;

import java.util.List;

public class UserDetailsTrainingDto {

    private Integer id;

    private Integer trainingId;

    private Integer userDetailsId;

    private Integer sets;

    private Integer reps;

    private List<Integer> weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Integer> getWeight() {
        return weight;
    }

    public void setWeight(List<Integer> weight) {
        this.weight = weight;
    }
}
