package com.kakaopay.invest.controller;

import com.kakaopay.invest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(
        properties = {
                "startDt=20210101",
                "finishDt=20211212"
        },
        controllers = {
                ProductController.class
        }
)
class ProductControllerTest {

    @MockBean private ProductService productService;
    @Autowired private MockMvc mockMvc;
    @Autowired private WebApplicationContext ctx;
    @Value("${startDt}") private String startDt;
    @Value("${finishDt}") private String finishDt;

    @BeforeEach // Junit4의 @Before
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    void getProducts() throws Exception {
        log.info("values >> {}, {}", startDt, finishDt);
        this.mockMvc
                .perform(get("/api/v1/products" +
                    "?startDt=" + startDt +
                    "&finishDt=" + finishDt))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getProducts2() throws Exception {
        log.info("values >> {}, {}", startDt, finishDt);
        startDt = null;
        this.mockMvc
                .perform(get("/api/v1/products" +
                        "?startDt=" + startDt +
                        "&finishDt=" + finishDt))
                .andDo(print());
    }
}