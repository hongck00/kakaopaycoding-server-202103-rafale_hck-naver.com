package com.example.invest.service.impl;

import com.example.invest.mapper.ProductMapper;
import com.example.invest.model.ProductInfoModel;
import com.example.invest.service.ProductService;
import com.example.invest.dto.ProductInvestDto;
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
    public List<ProductInfoModel> getProducts() {
        return productMapper.selectProductAll();
    }

    @Override
    public List<ProductInvestDto> getProduct(String startDt, String finishDt) {
        return productMapper.selectProduct(startDt, finishDt);
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
