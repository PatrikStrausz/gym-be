package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class DietCreateUpdateDto {

    @NotNull(message = "name.cannot.be.null")
    private String name;

    public DietCreateUpdateDto(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
