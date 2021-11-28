package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class ExerciseMuscleDto {

    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "muscleId.cannot.be.null")
    private int muscleId;

    @NotNull(message = "exerciseId.cannot.be.null")
    private int exerciseID;


    public ExerciseMuscleDto(int id, int muscleId, int exerciseID) {
        this.id = id;
        this.muscleId = muscleId;
        this.exerciseID = exerciseID;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMuscleId() {
        return muscleId;
    }

    public void setMuscleId(int muscleId) {
        this.muscleId = muscleId;
    }

    public int getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }


}
