package com.example.invest.common;

public enum InvestResult {

    S_0000("성공"), S_0001("조회 결과가 없습니다."), F_0000("실패")
    , F_0001( "사용자 정보가 없습니다.")
    , F_0002("투자 제품 정보가 없습니다.")
    , F_0003("투자 모집이 완료 되었습니다.")
    , F_0004("투자 상품이 sold-out 되었습니다.");

    private final String msg;

    public String getMsg() {
        return msg;
    }

    InvestResult(String msg) {
        this.msg = msg;
    }
}
