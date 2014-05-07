package ru.kpfu.it.leclib.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Ayrat on 23.04.2014.
 */

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private long id;

    @Size(min = 4, message = "Name min size: 4")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "Email does not be empty")
    @Email(message = "This email does not exist")
    @Column(name = "email")
    private String email;

    @Size(min = 6, message = "Password min size: 6")
    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "enabled")
    private boolean enabled = true;

    @OneToMany(mappedBy = "author")
    private List<Lecture> lectures;

    @ManyToMany
    @JoinTable(name = "USER_UR",
            joinColumns = {@JoinColumn(name = "uur_user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "uur_ur_id", referencedColumnName = "user_role_id")})
    private List<UserRole> role;

    @ManyToMany(mappedBy = "readers")
    private List<Lecture> availableLectures;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<UserRole> getRole() {
        return role;
    }

    public void setRole(List<UserRole> role) {
        this.role = role;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public List<Lecture> getAvailableLectures() {
        return availableLectures;
    }

    public void setAvailableLectures(List<Lecture> availableLectures) {
        this.availableLectures = availableLectures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
