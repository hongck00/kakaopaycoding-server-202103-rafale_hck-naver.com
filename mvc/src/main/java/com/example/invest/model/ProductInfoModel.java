package com.example.invest.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProductInfoModel {

    private long productId;
    private String title;
    private long totalInvestingAmount;
    private int status;
    private Timestamp startedAt;
    private Timestamp finishedAt;
}
