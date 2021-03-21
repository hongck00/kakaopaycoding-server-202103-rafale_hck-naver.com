package com.kakaopay.invest.mapper;

import com.kakaopay.invest.model.UserInvestModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface InvestMapper {

    @Insert("INSERT INTO" +
            " INVEST.USER_INVEST_INFO (user_seq, product_id, invest_amount, reg_dttm)" +
            " VALUES (#{userSeq}, #{productId}, #{investAmount}, NOW())")
    int insertInvest(long userSeq, long productId, long investAmount);

    @Select("SELECT *" +
            "  FROM INVEST.USER_INVEST_INFO" +
            " WHERE user_seq = #{userSeq} AND product_id = #{productId}")
    UserInvestModel selectUserInvest(long userSeq, long productId);

    @Update("UPDATE invest.user_invest_info" +
            "   SET invest_amount = #{investAmount}" +
            "     , alt_dttm = NOW()" +
            " WHERE user_seq = #{userSeq} AND product_id = #{productId}")
    int updateInvest(long userSeq, long productId, long investAmount);
}
