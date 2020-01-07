package com.chryl.admin.po;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Chryl on 2020/1/7.
 */
public class VRoleMenuParent implements Serializable {
    private static final long serialVersionUID = -3001299462101480380L;

    private Integer pId;
    private String pLabel;

    //一对多
    private List<VRoleMenuSun> children;


    public VRoleMenuParent() {
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpLabel() {
        return pLabel;
    }

    public void setpLabel(String pLabel) {
        this.pLabel = pLabel;
    }

    public List<VRoleMenuSun> getChildren() {
        return children;
    }

    public void setChildren(List<VRoleMenuSun> children) {
        this.children = children;
    }
}
