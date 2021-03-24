package com.example.invest.controller;

import com.example.invest.service.ProductService;
import com.example.invest.dto.ApiResponseDto;
import com.example.invest.dto.ProductInvestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public @ResponseBody ApiResponseDto<?> getProducts(
            @RequestParam String startDt,
            @RequestParam String finishDt) {

        var result = new ApiResponseDto<List<ProductInvestDto>>();

        var list = productService.getProduct(startDt, finishDt);
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
}
