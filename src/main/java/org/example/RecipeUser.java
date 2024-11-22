package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Check;

import java.sql.Date;

@Entity
//@Check(constraints = )//can be used for validation.
public class RecipeUser {
    @Id
    int id;

    String username;

    String email;

    String password;

    //Admin regularUser - perhaps using an enum doesn't include the constraint in database metadata?
    UserRole userRole;

    Date dateRegistered;

    public RecipeUser() {

    }

    public RecipeUser(int id, String username, String email, String password, UserRole userRole, Date dateRegistered) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.dateRegistered = dateRegistered;
    }

    @Override
    public String toString() {
        return "RecipeUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", dateRegistered=" + dateRegistered +
                '}';
    }
}
