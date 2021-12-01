package sk.kosickaakademia.strausz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "e_number")
public class ENumber {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "dangerous_level")
    private int dangerousLevel;

    public ENumber() {
    }

    public ENumber(String name, int dangerousLevel) {
        this.name = name;
        this.dangerousLevel = dangerousLevel;
    }
}
