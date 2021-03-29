package com.example.invest.controller;

import com.example.invest.dto.ApiResponseDto;
import com.example.invest.dto.ProductInvestDto;
import com.example.invest.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public @ResponseBody ApiResponseDto<?> getProducts(
            @RequestParam(required = false) String startDt,
            @RequestParam(required = false) String finishDt) {

        log.info("{}, {}", startDt, finishDt);

        var result = new ApiResponseDto<List<ProductInvestDto>>();

        List<ProductInvestDto> list = new ArrayList<>();
        if (startDt == null && finishDt == null) {
            list = productService.getProducts();
        } else {
            list = productService.getProduct(startDt, finishDt);
        }
        result.setData(list);
        result.setTotalCount(list.size());

        return result;
    }

    @GetMapping("/products/{id}")
    public ApiResponseDto getProductById(@PathVariable String id) {

        var result = new ApiResponseDto();
        result.setResultCode(id);

        return result;
    }

    @GetMapping("/products-all")
    public @ResponseBody ApiResponseDto<?> getProducts() {

        var result = new ApiResponseDto<>();
        var list = productService.getProducts();
        result.setData(list);

        return result;
    }
}
