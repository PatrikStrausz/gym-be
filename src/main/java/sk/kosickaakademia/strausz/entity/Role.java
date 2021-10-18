package sk.kosickaakademia.strausz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    @OneToOne(mappedBy = "role")
    private User user;

    public Role() {

    }

    public Role(int id, String name) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
