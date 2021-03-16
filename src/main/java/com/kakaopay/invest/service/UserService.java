package com.kakaopay.invest.service;

import com.kakaopay.invest.dto.UserInvestDto;

import java.util.List;

public interface UserService {

    boolean checkUser(int userSeq);

    List<UserInvestDto> getUserInvestList(int userSeq);
}
