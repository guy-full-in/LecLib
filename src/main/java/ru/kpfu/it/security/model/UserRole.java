package ru.kpfu.it.security.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ayrat on 23.04.2014.
 */
@Entity
@Table(name = "USER_ROLE")
public class UserRole {

    @Id
    @Column(name = "user_role_id")
    private long id;

    @Column(name = "authority")
    private String authority;

    public UserRole() {
    }

    public UserRole(String authority) {
        this.authority = authority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
