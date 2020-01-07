package com.chryl.admin.po;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Chryl on 2020/1/7.
 */
public class VRoleMenuSun implements Serializable {
    private static final long serialVersionUID = -2055144769266870391L;

    private Integer id;

    private String label;

    private Integer pid;

    public VRoleMenuSun() {
    }

    //自定义返回结构
    List<VRoleMenuSun> children;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<VRoleMenuSun> getChildren() {
        return children;
    }

    public void setChildren(List<VRoleMenuSun> children) {
        this.children = children;
    }
}
