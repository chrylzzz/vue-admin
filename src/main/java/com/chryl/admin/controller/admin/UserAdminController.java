package com.chryl.admin.controller.admin;

import com.chryl.admin.mapper.common.UserAdminMapper;
import com.chryl.admin.mapper.jpa.UserMapper;
import com.chryl.admin.po.User;
import com.chryl.admin.po.VPermissions;
import com.chryl.admin.po.VUser;
import com.chryl.core.response.ReturnResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * vue-admin 接口
 * mysql 连接,实现前端控制权限
 * <p>
 * Created by Chryl on 2019/12/31.
 */
@RestController
@RequestMapping("user")
public class UserAdminController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAdminMapper userAdminMapper;
    //user login 信息存储
    Map<String, Object> userMap = new ConcurrentHashMap<>();

    @PostMapping("/login")
    public Object show(@RequestBody VUser vuser) {
        String token = "9888a28586104f57970ec7c5666989a6";
        Map<String, Object> resMap = new HashMap<>();
        //校验用户密码成功,生成token
//        String token = stringRedisTemplate.opsForValue().get(user.getUsername());
        //模拟redis存储
        if (StringUtils.isNotBlank(vuser.getUsername())) {
            VUser vUser = userAdminMapper.selectVuserByUserName(vuser.getUsername());
            //校验
            if (vUser != null && StringUtils.isNotBlank(vUser.getPassword())) {
                if (vUser.getPassword().equals(vuser.getPassword())) {
                    userMap.put(token, vUser);

                    resMap.put("token", token);
                    resMap.put("code", "200");
                    resMap.put("status", "success");
                    return ReturnResult.create(resMap);
                }
            }
        }

//        if (StringUtils.isBlank(token)) {
//            token = UUID.randomUUID().toString().replaceAll("-", "");
////            stringRedisTemplate.opsForValue().set(user.getUsername(), token);
//        }
        System.out.println(token);

        resMap.put("token", token);
        resMap.put("code", "404");
        resMap.put("status", "fail login : password not validate  or username not validate");
        return ReturnResult.create(resMap);

    }

    //此接口为,用户登录之后 接着发送给服务端验证token信息接口
    @GetMapping("info")
    public Object show(String token) {
        //根据token验证用户信息,返回用户信息
        Map<String, Object> loginMap = new HashMap<>();
        if (StringUtils.isNotBlank(token)) {
            Object o = userMap.get(token);
            if (o != null) {
                VUser vUser = (VUser) o;
                //查询vuser的其他信息
                List<VPermissions> vPermissions = userAdminMapper.selectVuserById(vUser.getUserId());
                List<String> roles = new ArrayList<>();
                for (VPermissions vPermission : vPermissions) {
                    roles.add(vPermission.getPermissionsCode());
                }
                loginMap.put("roles", roles);
                loginMap.put("name", vUser.getUsername());
                loginMap.put("avatar", "avatar");
                loginMap.put("introduction", "introduction");
                loginMap.put("username", vUser.getUsername());
                loginMap.put("code", "200");
                loginMap.put("status", "success");
                return ReturnResult.create(loginMap);
            }

        }
        loginMap.put("code", "404");
        loginMap.put("status", "login fail  : password not validate  or username not validate");
        return ReturnResult.create(loginMap);
    }

    @PostMapping("logout")
    public ReturnResult logout(User user) {

        return ReturnResult.create("ok");
    }

    @GetMapping("/getUsers")
    public ReturnResult getUsers(User userVo) {
        Map<String, Object> res = new HashMap<>();
        List<User> users = new ArrayList<>(10);
        for (int i = 1; i < 19; i++) {
            User user = new User();
            user.setUsername("name-" + i);
            user.setPassword("pass-" + i);
            user.setId(i);
            user.setDate(new Date());
            user.setAge(i * 3);
            if (user.getAge() > 30) {
                user.setIsPass(1);
            } else {

                user.setIsPass(0);
            }
            users.add(user);
        }
        res.put("total", users.size());
        res.put("data", users);

        //有搜索
        List<User> searchUsers = new ArrayList<>(10);
        if (StringUtils.isNotBlank(userVo.getUsername())) {
            for (User user : users) {
                if (user.getUsername().contains(userVo.getUsername())) {
                    searchUsers.add(user);
                }
            }
            res.put("total", searchUsers.size());
            res.put("data", searchUsers);
        }

        return ReturnResult.create(res);
    }

    @PostMapping("/add")
    @Transactional
    public ReturnResult add(@RequestBody User user) {
        if (user != null) {
            if (null == user.getId()) {
                userMapper.save(user);
            } else if (null != user.getId()) {//更新
                userMapper.save(user);
            }
        }

        return ReturnResult.create("ok");
    }

    @GetMapping("/getUserInfoById")
    public ReturnResult getUserInfoById(String id) {

        Optional<User> optional = userMapper.findById(Integer.valueOf(id));
        if (optional.isPresent()) {
            return ReturnResult.create(optional.get());
        }
        return ReturnResult.create("不存在该用户");

    }

//    @PostMapping("/updateUser")
//    public ReturnResult updateUser(@RequestBody User user) {
//
//        if (user != null) {
//            userMapper.save(user);
//            return ReturnResult.create("ok");
//        }
//        return ReturnResult.create("err");
//
//    }

}
