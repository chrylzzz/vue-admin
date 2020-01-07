package com.chryl.admin.mapper.common;

import com.chryl.admin.po.VRoleMenu;
import com.chryl.admin.po.VRoleMenuParent;
import com.chryl.admin.po.VRoleSunPro;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Chryl on 2020/1/7.
 */
public interface RoleAdminMapper {


    List<VRoleMenuParent> getRoleMenu();

    List<VRoleMenu> getMenusByPid(@Param("pid") Integer pid);

    List<VRoleSunPro> getPermByRoleIdPro(@Param("roleId") Integer roleId);

    List<VRoleMenuParent> getParentMenu();
}
