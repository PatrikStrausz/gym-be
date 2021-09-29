package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class ExerciseMuscleDto {

    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "muscleId.cannot.be.null")
    private int muscleId;

    @NotNull(message = "exerciseId.cannot.be.null")
    private int exerciseID;


    @NotNull(message = "isMain.cannot.be.null")
    private boolean isMain;

    public ExerciseMuscleDto(int id, int muscleId, int exerciseID, boolean isMain) {
        this.id = id;
        this.muscleId = muscleId;
        this.exerciseID = exerciseID;
        this.isMain = isMain;
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

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }
}
