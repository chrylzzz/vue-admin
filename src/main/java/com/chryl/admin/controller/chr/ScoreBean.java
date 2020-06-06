package com.chryl.admin.controller.chr;

import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * Created by Chr.yl on 2020/6/5.
 *
 * @author Chr.yl
 */
@Data
public class ScoreBean {
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

    private String id;
    private String path;
    private String component;
    private String name;
    private Map meta;
    private ScoreBean children;
    private Set<String> roles;


}
