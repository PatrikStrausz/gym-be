package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class TrainingExerciseDto {

    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "exerciseId.cannot.be.null")
    private int exerciseId;

    @NotNull(message = "trainingId.cannot.be.null")
    private int trainingId;

    public TrainingExerciseDto(int id, int exerciseId, int trainingId) {
        this.id = id;
        this.exerciseId = exerciseId;
        this.trainingId = trainingId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }
}
