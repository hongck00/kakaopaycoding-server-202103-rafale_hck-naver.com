package com.kakaopay.invest.dto;

import com.kakaopay.invest.model.UserInvestModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserInvestDto extends UserInvestModel {

    private String title; // 상품 제목
    private long totalInvestingAmount; // 총 모집 금액
    private long investingAmount; // 나의 투자 금액
    private Timestamp investingDttm; // 투자 일시
}
