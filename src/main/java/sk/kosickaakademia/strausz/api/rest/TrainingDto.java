package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class TrainingDto {


    @NotNull(message = "id.cannot.be.null")
    private Integer id;

    @NotNull(message = "name.cannot.be.null")
    private String name;

    public TrainingDto(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
