package com.kakaopay.invest.service.impl;

import com.kakaopay.invest.common.InvestResult;
import com.kakaopay.invest.dto.InvestingProductDto;
import com.kakaopay.invest.dto.ProductInvestDto;
import com.kakaopay.invest.mapper.InvestMapper;
import com.kakaopay.invest.model.ProductInfoModel;
import com.kakaopay.invest.model.UserInvestModel;
import com.kakaopay.invest.service.InvestService;
import com.kakaopay.invest.service.ProductService;
import com.kakaopay.invest.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvestServiceImpl implements InvestService {

    private final UserService userService;
    private final ProductService productService;
    private final InvestMapper investMapper;

    @Override
    public InvestResult investingProduct(InvestingProductDto dto) {

        // 사용자 정보 체크
        if (!userService.checkUser(dto.getUserSeq())) {
            // 사용자 정보가 없습니다.
            log.warn("사용자 정보가 없습니다.");
            return InvestResult.F_0001;
        }
        // 상품 정보 체크
        ProductInvestDto productInfo = productService.getProduct(dto.getProductId());
        if (productInfo == null) {
            // 투자 제품 정보가 없습니다.
            log.warn("투자 제품 정보가 없습니다.");
            return InvestResult.F_0002;
        }

        // 투자 상태 체크 (0: 모집완료, 1: 모집중)
        if (productInfo.getStatus() == 0) {
            // 투자 모집 완료
            log.warn("투자 모집이 완료 되었습니다.");
            return InvestResult.F_0003;
        }

        ProductInvestDto productInvestInfo = productService.getProductInvestByProductId(dto.getProductId());
        long totalAmount = productInvestInfo.getTotalInvestingAmount();
        long currTotalAmount = productInvestInfo.getInvestAmount();
        int investingAmount = dto.getInvestingAmount();

        if (totalAmount < (investingAmount + currTotalAmount)) {
            // sold-out
            log.warn("투자 상품이 sold-out 되었습니다.");
            return InvestResult.F_0004;
        }

        int rsInvest = 0;
        UserInvestModel userInvest = investMapper.selectUserInvest(dto.getUserSeq(), dto.getProductId());
        if (userInvest == null) {
            rsInvest = investMapper.insertInvest(dto.getUserSeq(), dto.getProductId(), dto.getInvestingAmount());
        } else {
            long sum = userInvest.getInvestAmount() + dto.getInvestingAmount();
            rsInvest = investMapper.updateInvest(dto.getUserSeq(), dto.getProductId(), sum);
        }

        if (rsInvest > 0) {
            // 투자 성공
            log.info("투자 성공!");
            return InvestResult.S_0000;
        } else {
            // 투자 실패
            log.warn("투자 실패!");
            return InvestResult.F_0000;
        }
    }
}
