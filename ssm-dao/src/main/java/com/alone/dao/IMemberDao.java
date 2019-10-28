package com.alone.dao;

import com.alone.domain.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IMemberDao {
    //根据ID查询
    @Select("select * from member where id=#{id}")
    Member findById(String id);
}
