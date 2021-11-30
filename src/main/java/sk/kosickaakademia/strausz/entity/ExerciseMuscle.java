package sk.kosickaakademia.strausz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "exercise_muscle")
public class ExerciseMuscle {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "muscle_id")
    private Integer muscleId;

    @Column(name = "exercise_id")
    private Integer exerciseID;


    public ExerciseMuscle() {
    }

    public ExerciseMuscle(Integer muscleId, Integer exerciseID) {
        this.muscleId = muscleId;
        this.exerciseID = exerciseID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMuscleId() {
        return muscleId;
    }

    public void setMuscleId(Integer muscleId) {
        this.muscleId = muscleId;
    }

    public Integer getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(Integer exerciseID) {
        this.exerciseID = exerciseID;
    }
}
