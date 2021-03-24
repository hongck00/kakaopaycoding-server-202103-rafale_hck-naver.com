package com.example.invest.service;

import com.example.invest.common.InvestResult;
import com.example.invest.dto.InvestingProductDto;

public interface InvestService {

    InvestResult investingProduct(InvestingProductDto dto);
}
