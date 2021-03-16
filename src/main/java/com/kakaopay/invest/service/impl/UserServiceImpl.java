package com.kakaopay.invest.service.impl;

import com.kakaopay.invest.common.InvestResult;
import com.kakaopay.invest.dto.UserInvestDto;
import com.kakaopay.invest.mapper.UserMapper;
import com.kakaopay.invest.model.ProductInfoModel;
import com.kakaopay.invest.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public boolean checkUser(int userSeq) {
        return userMapper.selectUserByUserSeq(userSeq) != null;
    }

    @Override
    public List<UserInvestDto> getUserInvestList(int userSeq) {

        List<UserInvestDto> list = new ArrayList<>();

        // 사용자 확인
        if (!checkUser(userSeq)) {
            return list;
        }

        list = userMapper.selectUserInvestList(userSeq);

        return list;
    }
}
