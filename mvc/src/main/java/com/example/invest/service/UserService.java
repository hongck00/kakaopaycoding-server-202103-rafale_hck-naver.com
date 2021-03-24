package com.example.invest.service;

import com.example.invest.dto.UserInvestDto;

import java.util.List;

public interface UserService {

    boolean checkUser(int userSeq);

    List<UserInvestDto> getUserInvestList(int userSeq);
}
