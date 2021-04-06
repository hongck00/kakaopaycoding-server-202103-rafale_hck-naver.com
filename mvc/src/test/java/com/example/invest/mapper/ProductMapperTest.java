package com.example.invest.mapper;

import com.example.invest.config.DataSourceConfig1;
import com.example.invest.config.DataSourceConfig2;
import com.example.invest.dto.ProductInvestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {

    @Autowired private ProductMapper productMapper;

    @Test
    @DisplayName("상품 전체 조회")
    public void selectProductAll() {
        System.out.println("#########");
        List<ProductInvestDto> list =  productMapper.selectProductAll();
        System.out.println("ls size >> " + list.size());
    }
}