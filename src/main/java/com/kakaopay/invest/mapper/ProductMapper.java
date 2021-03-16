package com.kakaopay.invest.mapper;

import com.kakaopay.invest.dto.ProductInvestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT P.*" +
            "     , (SELECT sum(invest_amount) FROM INVEST.USER_INVEST_INFO WHERE product_id = P.product_id) AS investAmount" +
            "     , (select count(0) from invest.user_invest_info where product_id = P.product_id) AS investUserCount" +
            "  FROM INVEST.PRODUCT_INFO AS P" +
            " WHERE P.started_at >= #{startDt} AND P.finished_at <= #{finishDt}")
    List<ProductInvestDto> selectProduct(String startDt, String finishDt);

    @Select("SELECT P.*" +
            "     , (select sum(invest_amount) from invest.user_invest_info where product_id = P.product_id) AS investAmount" +
            "  FROM INVEST.PRODUCT_INFO P" +
            " WHERE P.product_id = #{productId}")
    ProductInvestDto selectProductInvestByProductId(int productId);

    @Select("SELECT P.*" +
            "  FROM INVEST.PRODUCT_INFO P" +
            " WHERE P.product_id = #{productId}")
    ProductInvestDto selectProductByProductId(int productId);
}
