package com.chryl.Vo;

import com.chryl.admin.po.VRole;

import java.io.Serializable;
import java.util.List;

/**
 * 接受role.vue
 * <p>
 * Created by Chryl on 2020/1/6.
 */
public class VRoleVo extends VRole implements Serializable {
    private static final long serialVersionUID = 23136882085716661L;

    //权限选中的tree
    private List<String> checkedKeys;

    public VRoleVo() {
    }

    public List<String> getCheckedKeys() {
        return checkedKeys;
    }

    public void setCheckedKeys(List<String> checkedKeys) {
        this.checkedKeys = checkedKeys;
    }
}
