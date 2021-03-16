package com.kakaopay.invest.service;

import com.kakaopay.invest.common.InvestResult;
import com.kakaopay.invest.dto.InvestingProductDto;

public interface InvestService {

    InvestResult investingProduct(InvestingProductDto dto);
}
