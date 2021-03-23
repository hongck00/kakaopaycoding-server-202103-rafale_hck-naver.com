package com.kakaopay.invest.controller;

import com.kakaopay.invest.dto.ApiResponseDto;
import com.kakaopay.invest.dto.ProductInvestDto;
import com.kakaopay.invest.model.ProductInfoModel;
import com.kakaopay.invest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<ApiResponseDto<?>> getProduct(
            @RequestParam String startDt,
            @RequestParam String finishDt) {

        var result = new ApiResponseDto<List<ProductInvestDto>>();

        var list = productService.getProduct(startDt, finishDt);
        result.setData(list);
        result.setTotalCount(list.size());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ApiResponseDto getProductById(@PathVariable String id) {

        var result = new ApiResponseDto();
        result.setResultCode(id);

        return result;
    }
}
