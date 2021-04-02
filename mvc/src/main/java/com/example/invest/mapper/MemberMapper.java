package com.example.invest.mapper;

import com.example.invest.model.MemberModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

    @Select("SELECT * from test.tMember LIMIT 1")
    MemberModel getMember();
}
