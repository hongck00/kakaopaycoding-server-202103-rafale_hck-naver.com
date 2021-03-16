package com.kakaopay.invest.service;

import com.kakaopay.invest.dto.ProductInvestDto;

import java.util.List;

public interface ProductService {

    List<ProductInvestDto> getProduct(String startDt, String finishDt);

    boolean checkProduct(int productId);

    ProductInvestDto getProduct(int productId);

    ProductInvestDto getProductInvestByProductId(int productId);
}
