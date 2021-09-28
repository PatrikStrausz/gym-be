package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class NutrientDto {

    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "name.cannot.be.null")
    private String name;

    @NotNull(message = "unitName.cannot.be.null")
    private String unitName;

    public NutrientDto(int id, String name, String unitName) {
        this.id = id;
        this.name = name;
        this.unitName = unitName;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
