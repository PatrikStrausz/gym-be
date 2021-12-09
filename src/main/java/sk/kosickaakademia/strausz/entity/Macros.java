package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "macros")
public class Macros {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "macrosSet", fetch = FetchType.EAGER)
    private Set<UserDetails> userDetailsSet;

    public Macros() {
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

    public Set<UserDetails> getUserDetailsSet() {
        return userDetailsSet;
    }

    public void setUserDetailsSet(Set<UserDetails> userDetailsSet) {
        this.userDetailsSet = userDetailsSet;
    }
}
