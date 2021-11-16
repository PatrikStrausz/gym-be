package sk.kosickaakademia.strausz.entity;

import javax.persistence.*;

@Entity(name = "user_role")
public class UserRole {


    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "user_role_sequence",
            sequenceName = "user_role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_role_sequence"
    )
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "role_id")
    private int roleId;

    public UserRole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
