package com.example.invest.controller;

import com.example.invest.common.InvestResult;
import com.example.invest.service.UserService;
import com.example.invest.dto.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 사용자 투자 목록 조회
    @GetMapping("/users/{userSeq}/invests")
    public ApiResponseDto getUserInvestList(@PathVariable int userSeq) {

        var result = new ApiResponseDto<>();

        var rsData = userService.getUserInvestList(userSeq);
        result.setData(rsData);
        result.setTotalCount(rsData.size());

        if ( rsData.size() == 0) {
            result.setResultMsg(InvestResult.S_0001.getMsg());
        }

        return result;
    }

    // 사용자 투자 상세 조회
    @GetMapping("/users/{userSeq}/invests/{productId}")
    public ApiResponseDto getUserInvestList(@PathVariable int userSeq, @PathVariable int productId) {

        var result = new ApiResponseDto<>();

        return null;
    }
}
