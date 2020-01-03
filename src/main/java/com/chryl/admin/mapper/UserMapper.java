package com.chryl.admin.mapper;

import com.chryl.admin.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Chryl on 2020/1/2.
 */
public interface UserMapper extends JpaRepository<User, Integer> {

}
