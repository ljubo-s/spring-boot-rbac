package com.springrbac.model;

import java.util.Set;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "permission")
public class Permission {

    private Long id;
    private String title;
    private String module;
    private String key;
    private Set<PermissionUsers> permissionUsers;

    public Permission() {
    }
    
    public Permission(String title, String module, String key) {
        super();
        this.title = title;
        this.module = module;
        this.key = key;
    }
    
    public Permission(String title, String module, String key, Set<PermissionUsers> permissionUsers) {
        super();
        this.title = title;
        this.module = module;
        this.key = key;
        this.permissionUsers = permissionUsers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "module")
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Column(name = "key")
    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @OneToMany
    @Cascade({CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "permission_id")
    public Set<PermissionUsers> getPermissionUsers() {
        return permissionUsers;
    }

    public void setPermissionUsers(Set<PermissionUsers> permissionUsers) {
        this.permissionUsers = permissionUsers;
    }

}
