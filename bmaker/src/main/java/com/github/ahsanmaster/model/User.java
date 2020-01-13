package com.github.ahsanmaster.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u ORDER BY u.firstName, u.lastName"),
})
@Entity
@Table(name = "users")
public class User {
    public static final String DELETE = "User.delete";
    public static final String ALL_SORTED = "User.getAllSorted";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "first_name")

    private String firstName;

    @Column(name = "last_name")

    private String lastName;

    @Column(name = "email")

    private String email;

    @Column(name = "year")

    private short year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }
}
