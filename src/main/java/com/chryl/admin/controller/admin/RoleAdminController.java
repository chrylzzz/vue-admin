package com.chryl.admin.controller.admin;

import com.chryl.Vo.VRoleVo;
import com.chryl.admin.mapper.common.RoleAdminMapper;
import com.chryl.admin.mapper.common.UserAdminMapper;
import com.chryl.admin.po.*;
import com.chryl.admin.service.UserAdminService;
import com.chryl.core.response.ReturnResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * role
 * <p>
 * Created by Chryl on 2020/1/6.
 */
@RestController
public class RoleAdminController {


    //    @Autowired
//    private VRoleRepo vRoleRepo;
    @Autowired
    private UserAdminService userAdminService;
    @Autowired
    private UserAdminMapper userAdminMapper;

    @GetMapping("roles")
    public Object roles() {
        List<VRole> roles = userAdminMapper.selectRoles();
        return ReturnResult.create(roles);
    }

    @GetMapping("routes")
    public Object routes() {
        List<VRoleMenu> vRoleMenus = userAdminService.selectRoleMenusByRolePermissions();
        return ReturnResult.create(vRoleMenus);
    }


    @GetMapping("/role/getPermissionsById/{roleId}")
    public Object getPermissionsById(@PathVariable String roleId) {
        if (StringUtils.isNotBlank(roleId)) {
//            List<VRole> havePermission = userAdminMapper.selectRoleMenuByRoleId(Integer.valueOf(roleId));
            List<Integer> integers = userAdminService.selectPerMissionsByRoleId(Integer.valueOf(roleId));
            return ReturnResult.create(integers);
        }
        return ReturnResult.create("参数不对");
    }

    //修改
    @Transactional
    @PutMapping("/role/{roleId}")
    public Object update(@PathVariable String roleId, @RequestBody VRoleVo vRoleVo) {
        //先删除 ,该觉得的所有 权限,重新设置权限
        if (StringUtils.isNotBlank(roleId)) {
            int i = userAdminMapper.deletePermByRoleId(Integer.valueOf(roleId));
            if (i >= 0) {

                VRole vRole = new VRole();
                BeanUtils.copyProperties(vRoleVo, vRole);
                //保存role信息
                int i1 = userAdminMapper.updateRoleById(vRole);
                if (i1 == 1) {
                    //保存新的权限信息
                    List<String> checkedKeys = vRoleVo.getCheckedKeys();
                    Set<String> chkKeys = new HashSet(checkedKeys);
                    int i2 = userAdminMapper.insertsRolePermsById(chkKeys, roleId);
                    if (i2 == chkKeys.size()) {
                        return ReturnResult.create("ok");
                    }
                }

            }
        }
        return ReturnResult.create("err");
    }

    //添加
    @Transactional
    @PostMapping("/role")
    public Object add(@RequestBody VRoleVo vRoleVo) {
        if (vRoleVo == null) {
            return "";
        }
        VRole vRole = new VRole();
        BeanUtils.copyProperties(vRoleVo, vRole);
        //添加role
        int i = userAdminMapper.insertRole(vRole);
        if (i == 1) {
            //添加权限
            if (vRoleVo.getCheckedKeys().size() == 0) {

            } else if (vRoleVo.getCheckedKeys().size() > 0) {
                Integer roleId = vRole.getRoleId();
                List<String> checkedKeys = vRoleVo.getCheckedKeys();
                Set<String> chkKeys = new HashSet<>(checkedKeys);
                int i2 = userAdminMapper.insertsRolePermsById(chkKeys, String.valueOf(roleId));
                if (i2 == vRoleVo.getCheckedKeys().size()) {
                    return ReturnResult.create("ok");
                }
                return ReturnResult.create("ok");
            }
        }
        return ReturnResult.create("err");
    }

    //删除
    @DeleteMapping("/role/{roleId}")
    public Object delete(@PathVariable String roleId) {
        //删除角色
        if (StringUtils.isNotBlank(roleId)) {
            int i = userAdminMapper.deleteRoleById(Integer.valueOf(roleId));
            //删除权限
            if (i == 1) {
                int i2 = userAdminMapper.deletePermByRoleId(Integer.valueOf(roleId));
                return ReturnResult.create("ok");
            }
        }
        return ReturnResult.create("err");
    }


    /**
     * Pro-----------------------------------------------
     */
    @Autowired
    private RoleAdminMapper roleAdminMapper;

    //所有权限列表
    @GetMapping("/routesPro")
    public Object routesPro() {
        List<VRoleMenuParent> roleMenuParents = roleAdminMapper.getRoleMenu();
        List<VRoleMenuSun> roleMenuSuns = new ArrayList<>();
        for (VRoleMenuParent menu : roleMenuParents) {
            VRoleMenuSun vRoleMenuSun = new VRoleMenuSun();
            vRoleMenuSun.setId(menu.getpId());
            vRoleMenuSun.setLabel(menu.getpLabel());
            vRoleMenuSun.setChildren(menu.getChildren());
            roleMenuSuns.add(vRoleMenuSun);
        }
        return ReturnResult.create(roleMenuSuns);
    }

    //默认选中的
    @GetMapping("/role/getPermissionsByIdPro/{roleId}")
    public Object getPermissionsByIdPro(@PathVariable String roleId) {
        if (StringUtils.isBlank(roleId)) {
            return ReturnResult.create("error");
        }
        List<VRoleSunPro> permByRoleIdPro = roleAdminMapper.getPermByRoleIdPro(Integer.valueOf(roleId));
        List<Integer> ids = new ArrayList<>();
        for (VRoleSunPro vRoleSunPro : permByRoleIdPro) {
            ids.add(vRoleSunPro.getgMenuSunId());
        }
        return ReturnResult.create(ids);
    }

    //得到所有的parentMenu
    @GetMapping("/getPerMenu")
    public Object getParentMenu() {
        List<VRoleMenuParent> parentMenu = roleAdminMapper.getParentMenu();
        return ReturnResult.create(parentMenu);
    }

    //添加2级
    @PostMapping("/addSecMenu/{pid}")
    public Object addSecMenu(@PathVariable StringUtils pid, @RequestBody VRoleMenuSun vRoleMenuSun) {

        return "";
    }

}
