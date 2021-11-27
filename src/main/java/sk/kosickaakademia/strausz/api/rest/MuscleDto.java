package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class MuscleDto {

    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "name.cannot.be.null")
    private String name;

    @NotNull(message = "imageSmall.cannot.be.null")
    private String imageSmall;

    @NotNull(message = "imageBig.cannot.be.null")
    private String imageBig;

    public MuscleDto(int id, String name, String imageSmall, String imageBig) {
        this.id = id;
        this.name = name;
        this.imageSmall = imageSmall;
        this.imageBig = imageBig;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }

    public String getImageBig() {
        return imageBig;
    }

    public void setImageBig(String imageBig) {
        this.imageBig = imageBig;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
