package sk.kosickaakademia.strausz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "preservative")
public class Preservative {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "dangerous_level")
    private int dangerousLevel;

    public Preservative() {
    }

    public Preservative(String name, int dangerousLevel) {
        this.name = name;
        this.dangerousLevel = dangerousLevel;
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

    public int getDangerousLevel() {
        return dangerousLevel;
    }

    public void setDangerousLevel(int dangerousLevel) {
        this.dangerousLevel = dangerousLevel;
    }
}
