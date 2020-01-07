package com.chryl.admin.mapper.common;

import com.chryl.admin.po.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * vue-admin-all
 * <p>
 * Created by Chryl on 2020/1/4.
 */
public interface UserAdminMapper {

    VUser selectVuserByUserName(@Param("username") String vUserName);

    List<VPermissions> selectVuserById(@Param("userId") Integer userId);

    //role -per :role 树
    List<VRole> selectRoles();

    List<VRole> selectRoleMenusByRolePermissions();

    //查看 role 现已已有哪些权限
    List<VRole> selectRoleMenuByRoleId(@Param("roleId") Integer roleId);

    List<VRolePermissions> selectPerMissionsByRoleId(@Param("roleId") Integer roleId);

    //更新权限
    int deletePermByRoleId(@Param("roleId") Integer roleId);

    int updateRoleById(@Param("role") VRole vRole);

    int insertsRolePermsById(@Param("perms") Set<String> perms, @Param("roleId") String roleId);

    //新增role
    int insertRole(@Param("role") VRole role);

    //删除role
    int deleteRoleById(@Param("roleId") Integer roleId);
}
