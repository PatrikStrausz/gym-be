package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "training_exercise")
public class TrainingExercise {

    @Id
    @SequenceGenerator(
            name = "training_exercise_sequence",
            sequenceName = "training_exercise_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "training_exercise_sequence"
    )
    @Column(name = "id")
    private int id;

    @Column(name = "exercise_id")
    private Integer exerciseId;

    @Column(name = "training_id")
    private Integer trainingId;

    public TrainingExercise() {
    }

    public TrainingExercise(Integer exerciseId, Integer trainingId) {
        this.exerciseId = exerciseId;
        this.trainingId = trainingId;
    }

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

    @Override
    public String toString() {
        return "TrainingExercise{" +
                "id=" + id +
                ", exerciseId=" + exerciseId +
                ", trainingId=" + trainingId +
                '}';
    }
}
