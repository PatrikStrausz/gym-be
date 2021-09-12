package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "training")
public class Training {

    @Id
    @SequenceGenerator(
            name = "training_sequence",
            sequenceName = "training_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "training_sequence"
    )
    private int id;

    private String name;

    private int exercise_id;


    public Training() {
    }


    public Training(String name, int exercise_id) {
        this.name = name;
        this.exercise_id = exercise_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }
}
