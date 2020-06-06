package com.chryl.admin.controller.chr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by Chr.yl on 2020/6/5.
 *
 * @author Chr.yl
 */
@RestController
@RequestMapping("/getScore")
public class ScoreController {

    @GetMapping("/getasyncRoutesInfo")
    public List<ScoreBean> show() {
        //    {
//        path: '/zzz',
//                component: Layout,
//            name: 'Zzz',
//            children: [
//        {
//            path: 'index',
//                    component: () => import('@/views/zzz/index'),
//                name: 'zzz',
//                meta: { title: 'Zzz', icon: 'table',
//            // roles: ['admin']
//
//        }
//        }
//    ]
//    },
        Map<String, String> s = new HashMap<>();
        s.put("title", "Zzz");
        s.put("icon", "table");
        Set<String> r = new HashSet<>();
        r.add("admin");

        ScoreBean scoreBean = new ScoreBean();
        scoreBean.setId("1");
        scoreBean.setPath("/zzz");
        scoreBean.setComponent("Layout");
        scoreBean.setName("Zzz");
        ScoreBean child = new ScoreBean();
        child.setPath("index");
        child.setComponent("() => import('@/views/zzz/index'),");
        child.setName("zzz");
        child.setMeta(s);
        child.setRoles(r);
        scoreBean.setChildren(child);
        return Arrays.asList(scoreBean);
    }
}
