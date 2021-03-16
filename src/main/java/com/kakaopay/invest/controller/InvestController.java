package com.kakaopay.invest.controller;

import com.kakaopay.invest.common.InvestConstant;
import com.kakaopay.invest.common.InvestResult;
import com.kakaopay.invest.dto.ApiResponseDto;
import com.kakaopay.invest.dto.InvestingProductDto;
import com.kakaopay.invest.service.InvestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class InvestController {

    private final InvestService investService;

    /*
        받는 값:
        -사용자 식별값: 헤
        -상품ID
        -투자금: 완료 되면 sold-out 처리 필요
    */
    @PostMapping("/invests/{productId}")
    public ApiResponseDto investingProduct(@RequestHeader(value = "X-USER-ID") int userSeq,
                                           @PathVariable int productId,
                                           @RequestBody InvestingProductDto req) {
        log.info("req : {}", req);
        req.setUserSeq(userSeq);
        req.setProductId(productId);

        var result = new ApiResponseDto();
        var rs = investService.investingProduct(req);
        if (InvestResult.S_0000 != rs) {
            // 실패
            result.setResultCode(InvestConstant.DEFAULT_RESULT_FAIL_CODE);
            result.setResultMsg(rs.getMsg());
        }

        return result;
    }
}
