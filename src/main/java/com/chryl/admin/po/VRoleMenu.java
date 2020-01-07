package com.chryl.admin.po;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Chryl on 2020/1/6.
 */
//@Entity
//@Table(name = "v_role_menu")
public class VRoleMenu implements Serializable {
    private static final long serialVersionUID = -6780767330638612350L;


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Integer id;

//    @Column(name = "label")
    private String label;

//    @Column(name = "parent_id")
    private Integer parentId;

    private List<VRoleMenu> children;

    public VRoleMenu() {
    }

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<VRoleMenu> getChildren() {
        return children;
    }

    public void setChildren(List<VRoleMenu> children) {
        this.children = children;
    }
}
