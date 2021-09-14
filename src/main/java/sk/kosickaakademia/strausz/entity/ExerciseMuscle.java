package sk.kosickaakademia.strausz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "exercise_muscle")
public class ExerciseMuscle {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "muscle_id")
    private int muscleId;

    @Column(name = "exercise_id")
    private int exerciseId;

    @Column(name = "is_main")
    private boolean isMain;

    public ExerciseMuscle() {
    }

    public ExerciseMuscle(int muscleId, int exerciseId, boolean isMain) {
        this.muscleId = muscleId;
        this.exerciseId = exerciseId;
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

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }
}
