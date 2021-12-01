package sk.kosickaakademia.strausz.api.rest;

public class ENumberDto {

    private Integer id;

    private String name;

    private int dangerousLevel;

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

    public int getDangerousLevel() {
        return dangerousLevel;
    }

    public void setDangerousLevel(int dangerousLevel) {
        this.dangerousLevel = dangerousLevel;
    }
}
