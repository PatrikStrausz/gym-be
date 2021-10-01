package sk.kosickaakademia.strausz.api.rest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {


    @NotNull(message = "id.cannot.be.null")
    private int id;

    @NotNull(message = "login.cannot.be.null")
    @Size(min = 6, message = "login.must.be.equal.or.greater.than.6.characters")
    private String login;

    @NotNull(message = "email.cannot.be.null")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "password.cannot.be.null")
    @Size(min = 8, message = "password.must.be.equal.or.greater.than.8.characters")
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
}
