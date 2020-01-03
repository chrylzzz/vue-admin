package com.chryl.admin.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Chryl on 2019/12/30.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = -6947163140069848588L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "date")
    private Date date;

    @Column(name = "age")
    private Integer age;
    @Column(name = "is_pass")
    private Integer isPass;

    public User() {
    }

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
