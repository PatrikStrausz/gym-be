package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "exercise_muscle")
public class ExerciseMuscle {

    @Id
    @SequenceGenerator(
            name = "exercise_muscle_sequence",
            sequenceName = "exercise_muscle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercise_muscle_sequence"
    )
    @Column(name = "id")
    private int id;

    @Column(name = "muscle_id")
    private int muscleId;

    @Column(name = "exercise_id")
    private int exerciseID;


    @Column(name = "is_main")
    private boolean isMain;

    public ExerciseMuscle() {
    }

    public ExerciseMuscle(int muscleId, int exerciseID, boolean isMain) {
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

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
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
