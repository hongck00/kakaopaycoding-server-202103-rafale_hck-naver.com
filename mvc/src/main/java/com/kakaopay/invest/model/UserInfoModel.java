package com.kakaopay.invest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoModel {

    private Long userSeq;
    private String userId;
    private String name;
}
