package com.chryl.admin.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Chryl on 2020/1/4.
 */
@Entity
@Table(name = "v_permissions")
public class VPermissions implements Serializable {
    private static final long serialVersionUID = 57565892299326087L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permissions_id")
    private Integer permissionsId;

    @Column(name = "permissions_code")
    private String permissionsCode;

    @Column(name = "permissions_desc")
    private String permissionsDesc;

    public VPermissions() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPermissioinsId() {
        return permissionsId;
    }

    public void setPermissioinsId(Integer permissionsId) {
        this.permissionsId = permissionsId;
    }

    public String getPermissionsCode() {
        return permissionsCode;
    }

    public void setPermissionsCode(String permissionsCode) {
        this.permissionsCode = permissionsCode;
    }

    public String getPermissionsDesc() {
        return permissionsDesc;
    }

    public void setPermissionsDesc(String permissionsDesc) {
        this.permissionsDesc = permissionsDesc;
    }
}
