package com.gourderwa.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * @author Wei.Li on 2016/3/9.
 */
@Entity
@Table(name = "users")

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Users {

    @Id
    @SequenceGenerator(name = "users_sequence1",sequenceName="users_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO ,generator = "users_sequence1")
    @Column(name = "id")
    private int id;

    @Column(name = "userName", length = 32)
    private String userName;

    public Users() {
    }

    public Users(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
