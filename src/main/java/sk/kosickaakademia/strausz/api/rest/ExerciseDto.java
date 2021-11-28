package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class ExerciseDto {

    @NotNull(message = "id.cannot.be.null")
    private Integer id;

    @NotNull(message = "name.cannot.be.null")
    private String name;

    @NotNull(message = "name.cannot.be.null")
    private String targetMuscleGroup;

    @NotNull(message = "exerciseType.cannot.be.null")
    private String exerciseType;

    @NotNull(message = "equipmentRequired.cannot.be.null")
    private String equipmentRequired;

    @NotNull(message = "mechanics.cannot.be.null")
    private String mechanics;

    @NotNull(message = "forcetype.cannot.be.null")
    private String forcetype;

    @NotNull(message = "experienceLevel.cannot.be.null")
    private String experienceLevel;

    @NotNull(message = "secondary_muscles.cannot.be.null")
    private String secondaryMuscles;

    @NotNull(message = "overview.cannot.be.null")
    private String overview;

    @NotNull(message = "instructions.cannot.be.null")
    private String instructions;

    @NotNull(message = "tips.cannot.be.null")
    private String tips;

    @NotNull(message = "image.cannot.be.null")
    private String image;

    @NotNull(message = "video.cannot.be.null")
    private String video;

    public ExerciseDto(Integer id, String name, String targetMuscleGroup, String exerciseType, String equipmentRequired,
                       String mechanics, String forcetype, String experienceLevel, String secondaryMuscles,
                       String overview, String instructions, String tips, String image, String video) {
        this.id = id;
        this.name = name;
        this.targetMuscleGroup = targetMuscleGroup;
        this.exerciseType = exerciseType;
        this.equipmentRequired = equipmentRequired;
        this.mechanics = mechanics;
        this.forcetype = forcetype;
        this.experienceLevel = experienceLevel;
        this.secondaryMuscles = secondaryMuscles;
        this.overview = overview;
        this.instructions = instructions;
        this.tips = tips;
        this.image = image;
        this.video = video;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
