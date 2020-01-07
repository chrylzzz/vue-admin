package com.chryl.admin.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Chryl on 2020/1/4.
 */
//@Entity
//@Table(name = "v_role")
public class VRole implements Serializable {
    private static final long serialVersionUID = -3283999049568321392L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "role_id")
    private Integer roleId;

//    @Column(name = "role_name")
    private String roleName;

//    @Column(name = "role_code")
    private String roleCode;

//    @Column(name = "role_desc")
    private String roleDesc;


    private List<VRoleMenu> children;

    public VRole() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<VRoleMenu> getChildren() {
        return children;
    }

    public void setChildren(List<VRoleMenu> children) {
        this.children = children;
    }
}
