package com.chryl.admin.service;

import com.chryl.admin.mapper.common.UserAdminMapper;
import com.chryl.admin.po.VRole;
import com.chryl.admin.po.VRoleMenu;
import com.chryl.admin.po.VRolePermissions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chryl on 2020/1/6.
 */
@Service
public class UserAdminService {

    @Resource
    private UserAdminMapper userAdminMapper;

    public List<Integer> selectPerMissionsByRoleId(Integer roleId) {
        List<VRolePermissions> vRolePermissions = userAdminMapper.selectPerMissionsByRoleId(roleId);
        List<VRole> roles = userAdminMapper.selectRoleMenuByRoleId(roleId);
        List<Integer> ids = new ArrayList<>();
        for (VRolePermissions vRolePermission : vRolePermissions) {
            Integer integer = vRolePermission.getgPermissionsId();
            ids.add(integer);
        }
        return ids;
    }

    public List<VRoleMenu> selectRoleMenusByRolePermissions() {
        List<VRole> roles = userAdminMapper.selectRoleMenusByRolePermissions();
        List<VRoleMenu> collect = roles.stream().map(role -> {
            VRoleMenu vRoleMenu = new VRoleMenu();
            return convertVRoleFromVRoleMenu(role, vRoleMenu);
        }).collect(Collectors.toList());

        return collect;
    }

    //vRole -> vRoleMenu
    private VRoleMenu convertVRoleFromVRoleMenu(VRole vRole, VRoleMenu vRoleMenu) {
        if (vRole == null || vRoleMenu == null) {
            return null;
        }
        vRoleMenu.setId(vRole.getRoleId());
        vRoleMenu.setLabel(vRole.getRoleName());
        vRoleMenu.setChildren(vRole.getChildren());

        return vRoleMenu;
    }


}
