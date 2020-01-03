package com.chryl.admin.controller;

import com.chryl.admin.po.User;
import com.chryl.core.response.ReturnResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Chryl on 2019/12/28.
 */
@RestController
@RequestMapping("/admin/user")
public class AdminController {
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/login")
    public ReturnResult show(@RequestBody User user) {

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

    @GetMapping("info")
    public ReturnResult show(String token) {
        User user = new User();
        user.setUsername("2");
        user.setPassword("222222");
        return ReturnResult.create(user);
    }

    @PostMapping("logout")
    public ReturnResult logout(User user){

        return ReturnResult.create("ok");
    }
}
