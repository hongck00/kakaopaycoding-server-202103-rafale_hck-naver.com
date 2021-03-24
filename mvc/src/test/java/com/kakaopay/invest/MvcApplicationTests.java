package com.kakaopay.invest;

import com.kakaopay.invest.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MvcApplicationTests {

    @Autowired private MockMvc mvc;
    @Autowired private ProductController productController;

    @Test
    void contextLoads() throws Exception {
    }
}
