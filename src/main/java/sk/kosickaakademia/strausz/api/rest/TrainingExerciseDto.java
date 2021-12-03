package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class TrainingExerciseDto {

    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "exerciseId.cannot.be.null")
    private Integer exerciseId;

    @NotNull(message = "trainingId.cannot.be.null")
    private Integer trainingId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }
}
