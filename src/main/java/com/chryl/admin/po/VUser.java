package com.chryl.admin.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Chryl on 2020/1/4.
 */
@Entity
@Table(name = "v_user")
public class VUser implements Serializable {
    private static final long serialVersionUID = 5986747444379192702L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "is_pass")
    private Integer isPass;

    @Column(name = "g_role_id")
    private Integer gRoleId;


    public VUser() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    public Integer getgRoleId() {
        return gRoleId;
    }

    public void setgRoleId(Integer gRoleId) {
        this.gRoleId = gRoleId;
    }
}
