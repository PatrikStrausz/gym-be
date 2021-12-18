package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "training")
public class Training {

    @Id
    @Column(name = "id")
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

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "training_exercise",
            joinColumns = @JoinColumn(name = "training_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    private Set<Exercise> exerciseSet;


    @ManyToMany(mappedBy = "trainingSet")
    private Set<UserDetails> userDetailsSet;


    public Training() {
    }

    public Training(String name) {
        this.name = name;
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


    public Set<Exercise> getExerciseSet() {
        return exerciseSet;
    }

    public void setExerciseSet(Set<Exercise> exerciseSet) {
        this.exerciseSet = exerciseSet;
    }

    public Set<UserDetails> getUserDetailsSet() {
        return userDetailsSet;
    }

    public void setUserDetailsSet(Set<UserDetails> userDetailsSet) {
        this.userDetailsSet = userDetailsSet;
    }
}
