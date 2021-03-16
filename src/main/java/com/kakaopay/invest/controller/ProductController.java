package com.kakaopay.invest.controller;

import com.kakaopay.invest.dto.ApiResponseDto;
import com.kakaopay.invest.dto.ProductInvestDto;
import com.kakaopay.invest.model.ProductInfoModel;
import com.kakaopay.invest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ApiResponseDto<List<ProductInvestDto>> getProduct(
            @RequestParam String startDt,
            @RequestParam String finishDt) {

        var result = new ApiResponseDto<List<ProductInvestDto>>();

        var list = productService.getProduct(startDt, finishDt);
        result.setData(list);
        result.setTotalCount(list.size());

        return result;
    }
}
