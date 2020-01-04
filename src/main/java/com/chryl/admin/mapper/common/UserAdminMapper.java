package com.chryl.admin.mapper.common;

import com.chryl.admin.po.VPermissions;
import com.chryl.admin.po.VUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * vue-admin-all
 * <p>
 * Created by Chryl on 2020/1/4.
 */
public interface UserAdminMapper {

    VUser selectVuserByUserName(@Param("username") String vUserName);

    List<VPermissions> selectVuserById(@Param("userId") Integer userId);
}
