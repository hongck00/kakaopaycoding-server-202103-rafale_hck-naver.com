package com.kakaopay.invest.service.impl;

import com.kakaopay.invest.dto.ProductInvestDto;
import com.kakaopay.invest.mapper.ProductMapper;
import com.kakaopay.invest.model.ProductInfoModel;
import com.kakaopay.invest.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public List<ProductInvestDto> getProduct(String startDt, String finishDt) {

        var list = productMapper.selectProduct(startDt, finishDt);

        return list;
    }

    @Override
    public boolean checkProduct(int productId) {
        return productMapper.selectProductByProductId(productId) != null;
    }

    @Override
    public ProductInvestDto getProduct(int productId) {
        return productMapper.selectProductByProductId(productId);
    }

    @Override
    public ProductInvestDto getProductInvestByProductId(int productId) {
        return productMapper.selectProductInvestByProductId(productId);
    }
}
