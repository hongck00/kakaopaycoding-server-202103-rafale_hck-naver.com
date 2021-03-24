package com.kakaopay.invest.service.impl;

import com.kakaopay.invest.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@Slf4j
@SpringBootTest(
        classes = {
                ProductServiceImpl.class
        }
//        , properties = {
//        }
)
//@RequiredArgsConstructor
class ProductServiceImplTest {

    @MockBean private ProductMapper productMapper;

    @BeforeEach
    void setUp() {
        System.err.println("=================================================================================");
    }

    @Test
    void getProduct() {
        var list = productMapper.selectProduct("", "");
        System.out.println(list);
        log.info("list : {}", list);
    }
}