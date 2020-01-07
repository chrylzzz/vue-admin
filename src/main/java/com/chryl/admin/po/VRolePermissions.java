package com.chryl.admin.po;

import java.io.Serializable;

/**
 * Created by Chryl on 2020/1/6.
 */
public class VRolePermissions implements Serializable {
    private static final long serialVersionUID = 8060657759210314733L;

    private Integer gRoleId;

    private Integer gPermissionsId;

    public VRolePermissions() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getgRoleId() {
        return gRoleId;
    }

    public void setgRoleId(Integer gRoleId) {
        this.gRoleId = gRoleId;
    }

    public Integer getgPermissionsId() {
        return gPermissionsId;
    }

    public void setgPermissionsId(Integer gPermissionsId) {
        this.gPermissionsId = gPermissionsId;
    }
}
