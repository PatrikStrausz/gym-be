package sk.kosickaakademia.strausz.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "exercise_muscle")
public class ExerciseMuscle {

    @Id
    private int id;

    private int muscle_id;

    private int exercise_id;

    private boolean is_main;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMuscle_id() {
        return muscle_id;
    }

    public void setMuscle_id(int muscle_id) {
        this.muscle_id = muscle_id;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }

    public boolean isIs_main() {
        return is_main;
    }

    public void setIs_main(boolean is_main) {
        this.is_main = is_main;
    }
}
