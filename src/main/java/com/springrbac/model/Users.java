package com.springrbac.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class Users {

    private Long id;
    private String username;
    private String password;
    private int status;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateofinsert;
    private Set<PermissionUsers> permissionUsers;

    public Users() {}

    public Users(String username, String password, int status) {
        super();
        this.username = username;
        this.password = password;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "dateofinsert")
    public Date getDateofinsert() {
        return this.dateofinsert;
    }

    public void setDateofinsert(Date dateofinsert) {
        this.dateofinsert = dateofinsert;
    }

    @OneToMany
    @Cascade({CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "users_id")
    public Set<PermissionUsers> getPermissionUsers() {
        return permissionUsers;
    }

    public void setPermissionUsers(Set<PermissionUsers> permissionUsers) {
        this.permissionUsers = permissionUsers;
    }

}
