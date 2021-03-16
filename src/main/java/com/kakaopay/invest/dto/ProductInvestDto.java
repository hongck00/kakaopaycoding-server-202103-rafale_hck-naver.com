package com.kakaopay.invest.dto;

import com.kakaopay.invest.model.ProductInfoModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductInvestDto extends ProductInfoModel {

    private long investAmount; // 현재 투자 금액
    private int investUserCount; // 현재 투자자 수
}
