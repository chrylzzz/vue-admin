package com.chryl.admin.po;

import java.io.Serializable;

/**
 * Created by Chryl on 2020/1/7.
 */
public class VRoleSunPro implements Serializable {
    private static final long serialVersionUID = -4052781550100570823L;

    private Integer gRoleId;

    private Integer gMenuSunId;

    public VRoleSunPro() {
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

    public Integer getgMenuSunId() {
        return gMenuSunId;
    }

    public void setgMenuSunId(Integer gMenuSunId) {
        this.gMenuSunId = gMenuSunId;
    }
}
