package com.chryl;

import com.chryl.admin.mapper.common.RoleAdminMapper;
import com.chryl.admin.po.*;
import com.chryl.admin.service.UserAdminService;
import com.chryl.admin.mapper.common.UserAdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VueAdminApplicationTests {

    @Autowired
    private UserAdminMapper userAdminMapper;
    @Autowired
    private UserAdminService userAdminService;
    @Autowired
    private RoleAdminMapper roleAdminMapper;

    @Test
    public void contextLoads() {
//		List<VRoleMenu> vRoleMenus = userAdminMapper.selectRoleMenus();
//		System.out.println(vRoleMenus);

//		List<VRoleMenu> vRoleMenus = userAdminService.selectRoleMenu();
//		System.out.println(vRoleMenus);


//        List<VRole> roles = userAdminMapper.selectRoleMenusByRolePermissions();
//        System.out.println(roles);


//        List<VRolePermissions> vRolePermissions = userAdminMapper.selectPerMissionsByRoleId(1);
//        System.out.println(vRolePermissions);


//        VRole vRole=new VRole();
//        vRole.setRoleName("测试2");
//        vRole.setRoleDesc("测试22");
//        int i = userAdminMapper.insertRole(vRole);
//        System.out.println(vRole.getRoleId());
//        System.out.println(vRole);


//        List<VRoleMenuParent> roleMenu = roleAdminMapper.getRoleMenu();
//        System.out.println(roleMenu);

//        //-1
//        Integer i1=new Integer(-1);
//        List<VRoleMenu> de = roleAdminMapper.getMenusByPid(i1);
//        //1
//        System.out.println(de);

        List<VRoleSunPro> permByRoleIdPro = roleAdminMapper.getPermByRoleIdPro(1);
        System.out.println(permByRoleIdPro);

    }

}
