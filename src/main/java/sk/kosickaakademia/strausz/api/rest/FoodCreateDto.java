package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.NotNull;

@Deprecated

public class FoodCreateDto {


    @NotNull(message = "name.is.required")
    private String name;

}
