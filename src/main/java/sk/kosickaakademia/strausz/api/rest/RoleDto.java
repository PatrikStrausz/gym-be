package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

public class RoleDto {

    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "name.cannot.be.null")
    private String name;

    public RoleDto(int id, String name) {
        this.id = id;
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
}
