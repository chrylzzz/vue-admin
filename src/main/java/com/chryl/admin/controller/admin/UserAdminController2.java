package com.chryl.admin.controller.admin;

import com.chryl.admin.mapper.jpa.UserMapper;
import com.chryl.admin.po.User;
import com.chryl.core.response.ReturnResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * vue-admin 接口
 * 无db连接,实现前端控制权限
 * <p>
 * Created by Chryl on 2019/12/31.
 */
@RestController
@RequestMapping("user1")
public class UserAdminController2 {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public Object show(@RequestBody User user) {
        //校验用户密码成功
//        String token = stringRedisTemplate.opsForValue().get(user.getUsername());
        String token = "9888a28586104f57970ec7c5666989a6";
        if (StringUtils.isBlank(token)) {
            token = UUID.randomUUID().toString().replaceAll("-", "");
//            stringRedisTemplate.opsForValue().set(user.getUsername(), token);
        }
        System.out.println(token);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("code", "200");
        map.put("status", "success");
        return ReturnResult.create(map);
    }
    //此接口为,用户登录之后 接着发送给服务端验证token信息接口
    @GetMapping("info")
    public Object show(String token) {
        //验证token
        User user = new User();
        user.setUsername("admin");
        user.setPassword("111111");
        //
        Map<String, Object> loginMap = new HashMap<>();
        String[] roles = {"admin", "editor"};
//        String[] roles = {"1", "2"};
//        String[] roles = {"admin", "2"};
//        String[] roles = {"editor", "2"};
        String name = "admin";
        String avatar = "avatar";
        String introduction = "introduction";
        loginMap.put("roles", roles);
        loginMap.put("name", name);
        loginMap.put("avatar", avatar);
        loginMap.put("introduction", introduction);
        loginMap.put("username", "admin");

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
