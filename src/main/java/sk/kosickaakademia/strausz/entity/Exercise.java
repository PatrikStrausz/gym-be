package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "Exercise")
public class Exercise {

    @Id
    @SequenceGenerator(
            name = "exercise_sequence",
            sequenceName = "exercise_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercise_sequence"
    )
    private int id;


    private String exercise_type;

    private String equipment_required;

    private String mechanics;

    private String forcetype;

    private String experience_level;

    private String overview;

    private String instructions;

    private String tips;

    private String image;

    private String video;

    public Exercise() {
    }

    public Exercise( String exercise_type, String equipment_required, String mechanics, String forcetype, String experience_level, String overview, String instructions, String tips, String image, String video) {
        this.exercise_type = exercise_type;
        this.equipment_required = equipment_required;
        this.mechanics = mechanics;
        this.forcetype = forcetype;
        this.experience_level = experience_level;
        this.overview = overview;
        this.instructions = instructions;
        this.tips = tips;
        this.image = image;
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExercise_type() {
        return exercise_type;
    }

    public void setExercise_type(String exercise_type) {
        this.exercise_type = exercise_type;
    }

    public String getEquipment_required() {
        return equipment_required;
    }

    public void setEquipment_required(String equipment_required) {
        this.equipment_required = equipment_required;
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

    public String getExperience_level() {
        return experience_level;
    }

    public void setExperience_level(String experience_level) {
        this.experience_level = experience_level;
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
}
