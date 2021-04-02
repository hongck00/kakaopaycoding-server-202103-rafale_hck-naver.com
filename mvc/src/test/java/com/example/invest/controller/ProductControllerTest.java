package com.example.invest.controller;

import com.example.invest.mapper.ProductMapper;
import com.example.invest.service.ProductService;
import com.example.invest.service.impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest(
        properties = {
                "startDt=20210101",
                "finishDt=20211212"
        }
)
@AutoConfigureMybatis
@AutoConfigureMockMvc
class ProductControllerTest {

    /* mock */
    @Autowired private MockMvc mockMvc;
    @Autowired private WebApplicationContext ctx;

    /* service */
    @Autowired private ProductController productController;
    @Autowired private ProductService productService;
    @Autowired private ProductServiceImpl productServiceImpl;
    @Autowired private ProductMapper productMapper;


    /* value */
    @Value("${startDt}") private String startDt;
    @Value("${finishDt}") private String finishDt;

    @BeforeAll
    public static void setUpAll() {
        System.out.println("========== BeforeAll ==========");
    }

    @BeforeEach // Junit4의 @Before
    public void setUp() {
        System.out.println("========== BeforeEach ==========");
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("상품 날짜 조회 null인 경우")
    public void getProductsByDate() throws Exception {
        System.out.println("========== 상품 날짜 조회 null인 경우 ==========");
        startDt = null;
        finishDt = null;
        log.info("values >> {}, {}", startDt, finishDt);
        this.mockMvc
                .perform(get("/api/v1/products" +
                    "?startDt=" + startDt +
                    "&finishDt=" + finishDt))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("상품 날짜 조회")
    public void getProducts2() throws Exception {
        System.out.println("========== 상품 날짜 조회 ==========");
        log.info("values >> {}, {}", startDt, finishDt);
        startDt = null;
        this.mockMvc
                .perform(get("/api/v1/products" +
                        "?startDt=" + startDt +
                        "&finishDt=" + finishDt))
                .andDo(print());
    }

    @Test
    @DisplayName("상품 전체 조회")
    public void getProducts() throws Exception {
        System.out.println("========== 상품 전체 조회 ==========");
        MvcResult result = this.mockMvc
                .perform(get("/api/v1/products"))
                .andDo(print())
                .andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(status, 200);
    }

    @AfterEach
    public void end() {
        System.out.println("========== AfterEach ==========");
    }

    @AfterAll
    public static void endAll() {
        System.out.println("========== AfterAll ==========");
    }
}
