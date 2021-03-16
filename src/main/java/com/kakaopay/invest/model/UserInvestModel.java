package com.kakaopay.invest.model;

import lombok.Data;

@Data
public class UserInvestModel {

    private long userSeq;
    private long productId;
    private long investAmount;
}
