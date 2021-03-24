package com.example.invest.etc;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

@Slf4j
public class EtcTest {

    @Test
    void nullCheck() {
        String str1 = null;
        boolean rs = ObjectUtils.isEmpty(str1);
        log.warn("rs >> {}", rs);
    }
}
