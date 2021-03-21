package com.kakaopay.invest.mapper;

import com.kakaopay.invest.dto.UserInvestDto;
import com.kakaopay.invest.model.UserInfoModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

     String SCHEMA_TABLE = "INVEST.USER_INFO";

    @Select("SELECT *" +
            "  FROM " + SCHEMA_TABLE +
            " WHERE user_seq = #{userSeq}")
    UserInfoModel selectUserByUserSeq(int userSeq);

    @Select("SELECT UI.product_id, UI.user_seq" +
            "     , UI.invest_amount AS investingAmount" +
            "     , IFNULL(UI.alt_dttm, UI.reg_dttm) AS investingDttm" +
            "     , P.title, P.total_investing_amount," +
            "  FROM INVEST.USER_INVEST_INFO UI" +
            " INNER JOIN invest.product_info P ON UI.product_id = P.product_id" +
            " WHERE UI.user_seq = #{userSeq}")
    List<UserInvestDto> selectUserInvestList(int userSeq);
}
