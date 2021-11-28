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
    private int exerciseID;


    public ExerciseMuscle() {
    }

    public ExerciseMuscle(int muscleId, int exerciseID) {
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
