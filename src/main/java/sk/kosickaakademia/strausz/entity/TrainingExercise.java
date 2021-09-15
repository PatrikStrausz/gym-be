package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "training_exercise")
public class TrainingExercise {

    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "training_exercise_sequence",
            sequenceName = "training_exercise_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "training_exercise_sequence"
    )
    private int id;

    @Column(name = "exercise_id")
    private int exerciseId;

    @Column(name = "training_id")
    private int trainingId;

    public TrainingExercise() {
    }

    public TrainingExercise(int exerciseId, int trainingId) {
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
