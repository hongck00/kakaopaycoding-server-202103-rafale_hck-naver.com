package com.example.invest.dto;

import com.example.invest.common.InvestConstant;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ApiResponseDto<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String resultCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String resultMsg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer totalCount;

    public ApiResponseDto() {
        this.resultCode = InvestConstant.DEFAULT_RESULT_SUCCESS_CODE;
        this.resultMsg = InvestConstant.DEFAULT_RESULT_MSG;
    }
}
