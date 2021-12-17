package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class UserDto {


    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "username.cannot.be.null")
    @Size(min = 6, message = "login.must.be.equal.or.greater.than.6.characters")
    private String username;

    @NotNull(message = "email.cannot.be.null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "password.cannot.be.null")
    @Size(min = 8, message = "password.must.be.equal.or.greater.than.8.characters")
    private String password;

    @NotNull(message = "roleID.cannot.be.null")
    private Set<Integer> roleId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Integer> getRoleId() {
        return roleId;
    }

    public void setRoleId(Set<Integer> roleId) {
        this.roleId = roleId;
    }


}
