package sk.kosickaakademia.strausz.api.rest;

public class MineralDto {


    private Integer id;

    private String name;

    private String function;

    private String foodSources;

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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFoodSources() {
        return foodSources;
    }

    public void setFoodSources(String foodSources) {
        this.foodSources = foodSources;
    }
}
