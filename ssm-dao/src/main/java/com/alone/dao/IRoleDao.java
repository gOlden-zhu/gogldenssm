package com.alone.dao;

import com.alone.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role where id in (select id from users_role where roleid=#{roleId})")
    List<Role> findById(String roleId);

}
