package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


//    @OneToOne(mappedBy = "role")
//    private User user;

    @ManyToMany
            (fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> userSet;


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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
