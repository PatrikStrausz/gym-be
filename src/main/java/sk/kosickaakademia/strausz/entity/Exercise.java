package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Exercise")
public class Exercise {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "target_muscle_group")
    private String targetMuscleGroup;

    @Column(name = "exercise_type")
    private String exerciseType;

    @Column(name = "equipment_required")
    private String equipmentRequired;

    @Column(name = "mechanics")
    private String mechanics;

    @Column(name = "forcetype")
    private String forcetype;

    @Column(name = "experience_level")
    private String experienceLevel;

    @Column(name = "secondary_muscles")
    private String secondaryMuscles;

    @Column(name = "overview")
    private String overview;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "tips")
    private String tips;

    @Column(name = "image")
    private String image;

    @Column(name = "video")
    private String video;

    //TODO zmenit na manytoOne
    @ManyToMany
    @JoinTable(
            name = "exercise_muscle",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_id"))
    private Set<Muscle> muscleSet;


    @ManyToMany(mappedBy = "exerciseSet")
    private Set<Training> trainingSet;

    public Exercise() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public String getEquipmentRequired() {
        return equipmentRequired;
    }

    public void setEquipmentRequired(String equipmentRequired) {
        this.equipmentRequired = equipmentRequired;
    }

    public String getMechanics() {
        return mechanics;
    }

    public void setMechanics(String mechanics) {
        this.mechanics = mechanics;
    }

    public String getForcetype() {
        return forcetype;
    }

    public void setForcetype(String forcetype) {
        this.forcetype = forcetype;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Set<Muscle> getMuscleSet() {
        return muscleSet;
    }

    public void setMuscleSet(Set<Muscle> muscleSet) {
        this.muscleSet = muscleSet;
    }

    public Set<Training> getTrainingSet() {
        return trainingSet;
    }

    public void setTrainingSet(Set<Training> trainingSet) {
        this.trainingSet = trainingSet;
    }

    public String getTargetMuscleGroup() {
        return targetMuscleGroup;
    }

    public void setTargetMuscleGroup(String targetMuscleGroup) {
        this.targetMuscleGroup = targetMuscleGroup;
    }

    public String getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public void setSecondaryMuscles(String secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
